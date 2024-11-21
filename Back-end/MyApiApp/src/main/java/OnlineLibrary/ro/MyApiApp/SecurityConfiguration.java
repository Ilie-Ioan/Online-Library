package OnlineLibrary.ro.MyApiApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private MyUserService customerUserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        return  httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(registry->
                {
                    registry.requestMatchers("/home","/register/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                 })
                .formLogin(formLogin -> formLogin.permitAll())
                .build();
    }
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        UserDetails customer = User.builder()
//                .username("JustIlie")
//                .password("$2a$12$LnKcLNX8r0xddcItmAV7uuXd.2mv/zSmWf9u6c1O6TIbYCDANtdaG")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$12$z/UQ6s.lY/T/OLbDLxDnAuM8BB.1MLkManYQuWgCgDX.ArZVNSJsG")
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(customer,admin);
//    }

    @Bean
    public UserDetailsService customerUserService()
    {
        return  customerUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
