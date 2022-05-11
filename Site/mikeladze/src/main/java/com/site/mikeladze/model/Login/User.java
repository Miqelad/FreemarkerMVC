package com.site.mikeladze.model.Login;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="usr")
public class User {
    @Id
    //генерироваться будет автоматически
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    /*Как мы уже говорили, множество - это такой же способ хранения данных, как массив или список.
 Но особенность множества в том, что оно может хранить только уникальные значения.*/
/*В двух словах, @ElementCollection используется, когда существование дочернего объекта бессмысленно без родительского объекта,
 т. Е. Всякий раз, когда родительский объект удаляется, ваши дети также будут*/

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER )
    /*вы все равно можете управлять именами таблиц и столбцов, используя аннотацию @CollectionTable.*/
    @CollectionTable(name="usrole",joinColumns = @JoinColumn(name ="uid" ))
    /*Указываем, что это enum и хранить мы его хотим в виде строки*/
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
