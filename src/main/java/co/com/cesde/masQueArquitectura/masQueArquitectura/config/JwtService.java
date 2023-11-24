package co.com.cesde.masQueArquitectura.masQueArquitectura.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtService {
    private static final String CLAVE_SECRETA = "5c475f251cb14162774ecbc0a2946ca4dad29ceddf5c08dcbb5d89c8cfb145f8";

    public String generarToken(UserDetails userDetails){
        return generarToken(new HashMap<>(), userDetails);
    }

    public String generarToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60 *24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmail(String token){
        return getClaim(token, Claims::getSubject);
    }

    public <T> T getClaim(String token, Function<Claims,T> resolvedor){
        final Claims claims = getAllClaims(token);
        return resolvedor.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSignInKey(){
        byte[] bytesKey = Decoders.BASE64.decode(CLAVE_SECRETA);
        return Keys.hmacShaKeyFor(bytesKey);
    }

    public boolean validarToken(String token, UserDetails userDetails){
        final String email = getEmail(token);
        return (email.equals(userDetails.getUsername()) && !expiradoToken(token));
    }

    private boolean expiradoToken(String token){
        return getExpirado(token).before(new Date());
    }

    private Date getExpirado(String token){
        return getClaim(token, Claims::getExpiration);
    }
}
