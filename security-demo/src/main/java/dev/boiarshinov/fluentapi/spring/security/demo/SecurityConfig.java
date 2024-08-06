package dev.boiarshinov.fluentapi.spring.security.demo;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Не настоящая конфигурация Spring Security.
 * Предназначена только для ознакомительных целей с различными версиями fluent API
 */
public class SecurityConfig {

    //
    // HTTP Basic аутентификация
    //
    // Доступы:
    // / - всем
    // /api/* - с аутентификацией
    // /maintain/* - только админам
    // /actuator/health - всем
    //
    // CSRF защита отключена
    //
    // Неавторизованных отправляем на страницу /not_authorized
    //


    public SecurityFilterChain configSecurityOld(HttpSecurity http) throws Exception {
        return http
            .httpBasic()
            .and()
            .authorizeRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/api/*").authenticated()
                .requestMatchers("/maintain/*").hasRole("ADMIN")
                .requestMatchers("/actuator/health").permitAll()
            .and()
            .csrf()
                .disable()
            .exceptionHandling()
                .accessDeniedPage("/not_authorized")
            .and()
            .build();
    }

    // Начиная с Spring Security 5.5
    public SecurityFilterChain configSecurityNew(HttpSecurity http) throws Exception {
        return http
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers("/api/*").authenticated()
                .requestMatchers("/maintain/*").hasRole("ADMIN")
                .requestMatchers("/actuator/health").permitAll()
            )
            .csrf(csrf -> csrf.disable())
            .exceptionHandling(exConf -> exConf.accessDeniedPage("/not_authorized"))
            .build();
    }
}
