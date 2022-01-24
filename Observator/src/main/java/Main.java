import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Main {
	
	//final List<String> listStrings = new ArrayList<String>();	
	//Thread myThread = new Thread(new Runnable());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable<String> msSender = Observable.just("mensaje 1", "mensaje 2", "mensaje 3");
		
		/*
		//por cada número generado el observador hará cosas
		Observable<String> msgSender = Observable.fromCallable(new Callable<String>() {
			
			public String call() throws Exception {
				Random r = new Random();
				return "mensaje " + r.nextInt(100) +1;
			}
			
		});
		*/
		
		msSender.subscribe(new Observer<String>() {

			public void onSubscribe(Disposable d) {
				System.out.println("Observer 1. Subscribed");
				
			}

			public void onNext(String t) {
				System.out.println("Observer 1. Recived");
				
			}

			public void onError(Throwable e) {
				System.out.println("Observer 1. Error" + e.getMessage());
				
			}

			public void onComplete() {
				System.out.println("Observer 1. completed");
				
			}
					
				
		});
		
		msSender.subscribe(new Observer<String>() {

			public void onSubscribe(Disposable d) {
				System.out.println("Observer 2. Subscribed");
				
			}

			public void onNext(String t) {
				System.out.println("Observer 2. Recived");
				
			}

			public void onError(Throwable e) {
				System.out.println("Observer 2. Error" + e.getMessage());
				
			}

			public void onComplete() {
				System.out.println("Observer 2. completed");
				
			}
					
				
		});
		Observer<String> observer1 = new Observer<String>() {

			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			public void onNext(String t) {
				// TODO Auto-generated method stub
				
			}

			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		Observer<String> observer2 = new Observer<String>() {

			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			public void onNext(String t) {
				// TODO Auto-generated method stub
				
			}

			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		msSender.subscribe(observer1);
		msSender.subscribe(observer1);
		
	}

}
