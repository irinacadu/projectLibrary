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
			IServiceOpinion opinionSrv, IServicePrestamo prestamoSrv, IServiceGenre genreSrv) {
		return args -> {

			// facultadSrv.save(Facultad.builder().nombre("INFORMATICA").build());
			genreSrv.save(Genre.builder().genre("Cuento Infantil").build());
			genreSrv.save(Genre.builder().genre("Ciencia Ficción").build());
			genreSrv.save(Genre.builder().genre("Ficción Contemporánea").build());
			genreSrv.save(Genre.builder().genre("Romance").build());
			genreSrv.save(Genre.builder().genre("Novela Fantástica").build());
			genreSrv.save(Genre.builder().genre("Novela Policiaca").build());
			genreSrv.save(Genre.builder().genre("Ensayo").build());

			userSrv.save(User.builder()
					.name("aaaa")
					.surname("BBBbbbbbbbbbb")
					.email("aaaa@bbbb.com")
					.phone("28323123")
					.birthDate(LocalDate.parse("1989-03-12"))
					.userName("asaassdasd")
					.password("asda123").build());

			userSrv.save(User.builder()
					.name("aaassfgsfga")
					.surname("nnnnn")
					.email("rrrrr@bbbb.com")
					.phone("2312q2452454")
					.birthDate(LocalDate.parse("1999-03-12"))
					.userName("aaaaaaa")
					.password("asda123").build());

			bookSrv.save(Book.builder()
					.title("Alicia en el País de las Maravillas")
					.author("Lewis Carrol")
					.sinopsis(
							"Novela que juega con la lógica. Alicia cae por un agujero, encontrándose un mundo peculiar. Alicia es una niña a la que no le gusta leer libros sin dibujos. Un día se encuentra con su hermana a la orilla de un río, aburrida y de repente ve cómo un conejo blanco revisa su reloj y exclama que llega tarde. ¿De dónde viene el conejo y por qué llega tarde? Movida por la curiosidad Alicia lo sigue y llega a un mundo subterráneo lleno de maravillas, donde vive miles de aventuras que rozan lo irracional, donde las situaciones son como en los sueños y los animales hablan")
					.photo("alicia.jpg")
					.genre(genreSrv.getGenre(1))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Dune")
					.author("Frank Herbert")
					.sinopsis(
							"Dune relata la historia del planeta desértico Arrakis, única fuente de melange, la especia necesaria para el viaje interestelar y que además garantiza longevidad y poderes psíquicos. La administración de Arrakis es transferida por el emperador de la noble Casa de Harkonnen a la Casa Atreides. Los primeros no quieren abandonar sus privilegios, y a través de traiciones y sabotajes, destierran al joven duque Paul Atreides al duro entorno del planeta para que muera. Pero Paul podría resultar ser mucho más que un duque al que han usurpado su puesto... Su lucha se encuentra en el epicentro de un nexo de poderosas personas e importantes sucesos, y las repercusiones se dejarán sentir a través del Imperio.")
					.photo("dune.jpg")
					.genre(genreSrv.getGenre(2))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Fahrenheit 451")
					.author("Ray Bradbury")
					.sinopsis("Fahrenheit 451 ofrece la historia de un sombrío y horroroso futuro. Montag, el protagonista, pertenece a una extraña brigada de bomberos cuya misión, paradójicamente, no es la de sofocar incendios sino la de provocarlos para quemar libros. Porque en el país de Montag está terminantemente prohibido leer.")
					.photo("451.jpg")
					.genre(genreSrv.getGenre(2))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Miedo y Asco en Las Vegas")
					.author("Hunter S. Thompson")
					.sinopsis("Ésta es la obra más enloquecida de Hunter S. Thompson, figura legendaria del Nuevo Periodismo. Una acción delirante: Thompson entró en Las Vegas pertrechado con un arsenal verdaderamente mágico de «nefandas sustancias químicas» en su búsqueda del Sueño Americano. Sus peligrosos enfrentamientos, dopado hasta las cejas, con los empleados de casinos, camareros, policías especializados en narcóticos y demás representantes de la Mayoría Silenciosa, segregan un humor alucinado y un clima de terror muy infrecuentes.")
					.photo("miedoyasco.jpg")
					.genre(genreSrv.getGenre(3))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Perdida")
					.author("Gillian Flynn")
					.sinopsis("En un caluroso día de verano, Amy y Nick se disponen a celebrar su quinto aniversario de bodas en North Carthage, a orillas del río Mississippi. Pero Amy desaparece esa misma mañana sin dejar rastro. A medida que la investigación policial avanza las sospechas recaen sobre Nick. Sin embargo, este insiste en su inocencia. Es cierto que se muestra extrañamente evasivo y frío, pero ¿es capaz de matar?")
					.photo("perdida.jpg")
					.genre(genreSrv.getGenre(3))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Grandes Esperanzas")
					.author("Charles Dickens")
					.sinopsis("Kent, Inglaterra, finales del siglo XIX. El huérfano Pip vive una existencia humilde con su hermana y su cuñado, a quien ayuda en su taller de herrería. Cuando la rica Miss Havisham requiere a Pip como acompañante de ella y de su bella hija, el joven se dará cuenta de las penurias de su clase social y deseará cada vez con más fuerza subir posiciones en el escalafón social. Pip recibirá entonces la visita de un abogado de Londres, quien le informará que un benefactor anónimo le quiere convertir en un caballero. Sin embargo, Pip descubrirá que el valor de la amistad y de la moral no se puede comprar con dinero")
					.photo("grandes.jpg")
					.genre(genreSrv.getGenre(4))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Harry Potter y la Piedra Filosofal")
					.author("J. K. Rowling")
					.sinopsis("Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y del insoportable primo Dudley. Harry se siente muy triste y solo, hasta que un buen día recibe una carta que cambiará su vida para siempre. En ella le comunican que ha sido aceptado como alumno en el colegio interno Hogwarts de magia y hechicería.', 'Harry Potter y la piedra filosofal")
					.photo("potter.jpg")
					.genre(genreSrv.getGenre(5))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("A Sangre Fría")
					.author("Truman Capote")
					.sinopsis("A sangre fría narra el brutal asesinato de los cuatro miembros de una familia de Kansas. En 1959, un violento crimen sacudió la tranquila vida de Holcomb, Kansas. La sociedad estadounidense de aquellos años quedó conmocionada por un crimen que sugería que cualquiera podía morir asesinado en cualquier momento.")
					.photo("capote.jpg")
					.genre(genreSrv.getGenre(6))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());
			
			bookSrv.save(Book.builder()
					.title("Lolita")
					.author("Vladimir Nabokov")
					.sinopsis("Humbert Humert es un profesor que se obsesiona con Dolores Haze (Lolita), la hija de 12 años de su mujer, Charlotte Haze. Cuando ella fallece, él se queda a cargo de la menor con quien termina estableciendo, a sus ojos, una relación de pareja")
					.photo("lolita.jpg")
					.genre(genreSrv.getGenre(3))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("El Cuento de la Criada")
					.author("Margaret Atwood")
					.sinopsis("¿Qué ocurriría si de un momento a otro un sistema democrático se ve derrocado por uno represivo, dictatorial y ultrareligioso? ¿Y si además las mujeres quedaran divididas en roles según su capacidad o no para concebir?")
					.photo("criada.jpg")
					.genre(genreSrv.getGenre(3))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("Una Habitación Propia")
					.author("Virginia Woolf")
					.sinopsis("En 1928 a Virginia Woolf le propusieron dar una serie de charlas sobre el tema de la mujer y la novela. Lejos de cualquier dogmatismo o presunción, planteó la cuestión desde un punto de vista realista, valiente y muy particular. Una pregunta: ¿qué necesitan las mujeres para escribir buenas novelas? Una sola respuesta: independencia económica y personal, es decir, Una habitación propia. Sólo hacía nueve años que se le había concedido el voto a la mujer y aún quedaba mucho camino por recorrer.")
					.photo("habitacion.jpg")
					.genre(genreSrv.getGenre(7))
					.user(userSrv.getUser(1))
					.opinions(opinionSrv.getOpiniones())
					.build());

			bookSrv.save(Book.builder()
					.title("La Ridícula Idea de No Volver a Verte")
					.author("Rosa Montero")
					.sinopsis("Cuando Rosa Montero leyó el maravilloso diario que Marie Curie comenzó tras la muerte de su esposo, y que se incluye al final de este libro, sintió que la historia de esa mujer fascinante que se enfrentó a su época le llenaba la cabeza de ideas y emociones.")
					.photo("ridicula.jpg")
					.genre(genreSrv.getGenre(7))
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
