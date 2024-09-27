package com.app;

import com.app.entity.Person;
import com.app.entity.User.PermissionEntity;
import com.app.entity.User.RoleEntity;
import com.app.entity.User.RoleEnum;
import com.app.entity.User.UserEntity;
import com.app.repository.PersonRepository;
import com.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class LoginSpringSecuritySenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSpringSecuritySenaApplication.class, args);
	}
	@Bean
	CommandLineRunner init(PersonRepository personRepository){
		return args -> {
			//PRIMER PASO: CREAR LOS PERMISOS
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			//SEGUNDO PASO: CREAR LOS ROLES
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.Admin)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.User)
					.permissionList(Set.of(createPermission,readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.Invited)
					.permissionList(Set.of(readPermission))
					.build();


			//TERCER PASO: CREAR LOS USUARIOS
			UserEntity userYunior = UserEntity.builder()
					.userName("yunior")
					.password("$2a$10$I1Itdk0EIJxSW2P1nF7u/u.rS2AjGxqdNhD/bT7SX0jzPunIZi5am")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userDaniel = UserEntity.builder()
					.userName("daniel")
					.password("$2a$10$I1Itdk0EIJxSW2P1nF7u/u.rS2AjGxqdNhD/bT7SX0jzPunIZi5am")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userJesus = UserEntity.builder()
					.userName("jesus")
					.password("$2a$10$I1Itdk0EIJxSW2P1nF7u/u.rS2AjGxqdNhD/bT7SX0jzPunIZi5am")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			//CUARTO PASO: CREAR LAS PERSONAS
			Person personYunior = Person.builder()
					.name("Yunior")
					.lastName("Gonzalez")
					.document("11111")
					.phone("32332344")
					.location("Quindio")
					.user(userYunior)
					.build();

			Person personDaniel = Person.builder()
					.name("Daniel")
					.lastName("Arias")
					.document("22222")
					.phone("3232323")
					.location("Armenia")
					.user(userDaniel)
					.build();

			Person personJesus = Person.builder()
					.name("Jesus")
					.lastName("Murillo")
					.document("33333")
					.phone("32321266")
					.location("Colombia")
					.user(userJesus)
					.build();

			personRepository.saveAll(List.of(personYunior,personDaniel,personJesus));
		};
	}
}
