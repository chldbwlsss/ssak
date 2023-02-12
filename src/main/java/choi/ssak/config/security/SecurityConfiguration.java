package choi.ssak.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                    .authorizeHttpRequests((authz) -> authz
                            .antMatchers("/h2/**").permitAll()
                            .antMatchers("/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .csrf().disable()
                    .headers().frameOptions().disable()
                    .and()
                    .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
