package com.example.springfinalproject.config;

import com.example.springfinalproject.service.OrganisationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity
public class Security {
    private OrganisationService organisationService;

    private PasswordEncoder passwordEncoder;

    public Security(OrganisationService organisationService, PasswordEncoder passwordEncoder) {
        this.organisationService = organisationService;
        this.passwordEncoder = passwordEncoder;
    }

//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//
//    }
    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable());
        http.headers(customizer -> customizer.disable());
        return http
                .userDetailsService(organisationService)
                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/", "/register", "/login", "/invoices").permitAll()/*tutaj wpiszemy nasze strony które mają być widoczne dla wszystkich*/
//                                .anyRequest().authenticated())
                        auth.anyRequest().permitAll())
                .formLogin(customizer -> customizer.loginPage("/login")
                        .permitAll())
//                .logout(Customizer.withDefaults())
                .logout(customizer -> customizer.logoutSuccessUrl("/"))
                /*
                po odkomentowaniu linijki 44 a zakomentowaniu 45
                po naciśnięciu przycisku logout będzie nas przekierowywało
                na stronę główną i automatycznie wyciągnięta aktualnie zalogowana
                organizacja zostanie spowrotem przestawiona na null
                 */
                .build();
    }



//
//    public Security(OrganisationService organisationService) {
//        this.organisationService = organisationService;
//    }
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration configuration) throws Exception{
//        return configuration.getAuthenticationManager();
//    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable()
//                .headers().disable() //for console
//                .authorizeHttpRequests((authorize) ->
//                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                                .requestMatchers("/console").permitAll()
//                        .requestMatchers("/api/authorisation/**").permitAll()
//                                .anyRequest().permitAll())
//                .formLogin();
//        return httpSecurity.build();
//    }
}
