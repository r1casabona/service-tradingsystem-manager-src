//package br.com.mrxfocus.api.tradingsystemmanager.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@EnableWebFluxSecurity
//public class EmployeeWebSecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(
//            ServerHttpSecurity http) {
//        http.csrf().disable()
//                .authorizeExchange()
////                .pathMatchers(HttpMethod.POST, "/negatives/update").hasRole("ADMIN")
//                .pathMatchers("/**").permitAll()
//                .and()
//                .httpBasic();
//        return http.build();
//    }
//}
