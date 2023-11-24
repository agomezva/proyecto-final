package co.com.cesde.masQueArquitectura.masQueArquitectura.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtFiltro jwtFiltro;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf ->
                csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(rutasPublicas()).permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(sess ->
                        sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFiltro, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(
                                                (request, response, authentication) ->
                                                SecurityContextHolder.clearContext()

                                )
                );

        return httpSecurity.build();
    }


    private RequestMatcher rutasPublicas(){
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/autenti/log"),
                new AntPathRequestMatcher("/autenti/registro"),
                new AntPathRequestMatcher("/servicio/all")
        );
    }

}
