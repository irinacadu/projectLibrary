package com.library;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.library.entities.Book;
import com.library.entities.Genre;
import com.library.entities.Opinion;
import com.library.entities.Prestamo;
import com.library.entities.User;
import com.library.services.IServiceBook;
import com.library.services.IServiceGenre;
import com.library.services.IServiceOpinion;
import com.library.services.IServicePrestamo;
import com.library.services.IServiceUser;

@SpringBootApplication
public class ProjectLibraryApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLibraryApplication.class, args);
	}
	@Bean
    public CommandLineRunner demoData(IServiceUser userSrv, IServiceBook bookSrv, 
	IServiceOpinion opinionSrv, IServicePrestamo prestamoSrv, IServiceGenre genreSrv){
        return args -> {

			//facultadSrv.save(Facultad.builder().nombre("INFORMATICA").build());
            genreSrv.save(Genre.builder().genre("ACTION").build());
		
			
			userSrv.save(User.builder()
			.name("aaaa")
			.surname("BBBbbbbbbbbbb")
			.email("aaaa@bbbb.com")
			.phone("28323123")
			.fechaNacimiento(LocalDate.parse("1989-03-12"))
			.userName("asaassdasd")
			.password("asda123").build());

			userSrv.save(User.builder()
			.name("aaassfgsfga")
			.surname("nnnnn")
			.email("rrrrr@bbbb.com")
			.phone("2312q2452454")
			.fechaNacimiento(LocalDate.parse("1999-03-12"))
			.userName("aaaaaaa")
			.password("asda123").build());

			bookSrv.save(Book.builder()
			.title("AASASDASDASDADADAS")
			.author("lllllllll")
			.sinopsis("adlaksdjlaksdlaksdlajdlaksjdlkajsdlkajsldk")
			.photo("a.jpg")
			.genre(genreSrv.getGenre(1))
			.user(userSrv.getUser(1))
			.opinions(opinionSrv.getOpiniones())
			.build());


			opinionSrv.save(Opinion.builder().opinion("lkjlkjlkj")
			.book(bookSrv.getBook(1))
			.user(userSrv.getUser(1)).build());


			prestamoSrv.save(Prestamo.builder()
			.deliveryDate(LocalDate.parse("2022-05-05"))
			.dueDate(LocalDate.parse("2022-05-10"))
			.book(bookSrv.getBook(1))
			.user(userSrv.getUser(1))
			.user2(userSrv.getUser(2)).build());
		};



 }
}
