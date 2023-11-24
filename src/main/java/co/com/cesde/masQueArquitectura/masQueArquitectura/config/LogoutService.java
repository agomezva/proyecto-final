package co.com.cesde.masQueArquitectura.masQueArquitectura.config;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;


    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
    {
       final String authHeader = request.getHeader("Authorization");
       final String token;

       if (authHeader == null || !authHeader.startsWith("Bearer ")){
           return;
       }

       token = authHeader.substring(7);
       var tokenGuardado = tokenRepository.findByToken(token)
               .orElse(null);

       if(tokenGuardado != null){
           tokenGuardado.setRevocado(true);
           tokenGuardado.setExpirado(true);
           tokenRepository.save(tokenGuardado);
       }
    }
}
