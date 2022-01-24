package flux;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux<String> msSender = Flux.just("mensaje 1", "mensaje 2", "mensaje 3");
		
		msSender.subscribe(message -> System.out.println("Observer 1. Received: " + message));
		System.out.println("");
		
		msSender.subscribe(message -> System.out.println("Observer 2. Received: " + message));
		System.out.println("");
		
		System.out.println("****** do on next -> blockFirst - resutado: mensaje 1 ***");
		System.out.println("");
		
		msSender.doOnNext((element) -> {
			 System.out.println(element);
		}).blockFirst();
		
		System.out.println("");
		
		System.out.println("******************** do on next -> blockLast - resultado: muestra todos los mensajes **********");
		System.out.println("");	
		
		msSender.doOnNext((element) -> {
			 System.out.println(element);
		}).blockLast();
		
		System.out.println("");
		
		System.out.println("******************** do finally -> bockFirst - resultado: cancel ****************");
		System.out.println("");		
		
		msSender.doFinally((element) -> {
			 System.out.println("doFinally " + element);
		}).blockFirst();
		
		System.out.println("******************** do finally -> bockLast - resultado: onComplete ****************");
		System.out.println("");
		
		msSender.doFinally((element) -> {
			 System.out.println("doFinally " + element);
		}).blockLast();
		
		


	}

}
