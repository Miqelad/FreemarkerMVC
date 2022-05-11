package com.site.mikeladze.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
/*Чтобы работал преавторайз*/
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*Datasource у нас генирируется спрингом и мы можем его легко получить*/
    @Autowired
    private DataSource dataSource;
    /*При старте система включает дает конфиг, включается авторизация*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//авторизация
                .antMatchers("/registration").permitAll()//на какие страницы мы разрешаем полнуй доступ
                .anyRequest().authenticated()//для всех остальных запросов мы требуем авторизацию
                .and()
                .formLogin()//включаем форму логина
                .loginPage("/login")//на таком мапинге находится форма для логина
                .permitAll()//разрешаем этим пользоваться всем
                .and()
                .logout()//выход тоже всем
                .permitAll();
    }
    /*Метод, чтобы брать данные из БД*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())//шифрование пароля
                /*pring security ожидает 3 столбца для запроса usersByUserName . Вот запрос по умолчанию, используемый, если вы его не указали.
                * Поэтому, если у вас нет такого столбца для включения и отключения пользователя, используйте следующий запрос
                * Поставили выдуманное поле*/
                .usersByUsernameQuery("select username, password, 'true' as enabled from usr where username=? ")
                /*Для получения ролей*/
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join usrole ur on u.id=ur.uid where u.username=?");
//                                         ("select u.username, ur.roles from usr u inner join user_role ur on u.id=ur.user_id where u.username=?");

    }

}



