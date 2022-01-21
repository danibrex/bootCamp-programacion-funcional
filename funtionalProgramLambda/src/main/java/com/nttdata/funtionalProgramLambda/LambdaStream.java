package com.nttdata.funtionalProgramLambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaStream {

	public static void main(String[] args) {
		
	    List<Integer> listNumbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		List<String> listStrings =  new ArrayList<>();
		
		// Cargar la lista de objetos del tipo Producto
		List<Product> shoppingCart = List.of(
				new Product("Clothes",new BigDecimal("15.90"), Tax.REDUCED),
				new Product("Bread",new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat",new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese",new BigDecimal("3.59"), Tax.REDUCED),
				new Product("Coke",new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey",new BigDecimal("19.90"), Tax.REDUCED)
				
		);

		/*
		 * Saber cuantos numeros son mayores que 10 de manera imperativa
		 */
		System.out.println("************************************************************************");
		System.out.println("****************************Imperativa**********************************");
		System.out.println("************************************************************************");
		
		int contador = 0;
		for (Integer num : listNumbers) {
			if (num > 10) {
				contador++;
				System.out.println("Números mayores de 10: " + num + ", Contador vale: " + contador);				
			}
		}

		
		System.out.println("************************************************************************");
		System.out.println("****************************Funcional***********************************");
		System.out.println("************************************************************************");
		
		/*
		 * Version lambda, incrementa la variable count cada vez que se aplique el filtro.
		 */
		
		Long count = listNumbers.stream().filter(num -> num > 10).count();
		
		System.out.println("Lambda: números mayores de 10: " + count);
		System.out.println("Tamaño de la lista shoppingCart: "+ shoppingCart.size());
		
		//Imprimir el nombre de cada objeto de la lista
		shoppingCart.stream().forEach(t -> System.out.println("nombre de productos: " + t.name));
		
		//NO FUNCIONA -- cargar la lista de cadenas con el nombre de los productos en el mapeado
		shoppingCart.stream().map(product -> listStrings.add(product.name));
		
		//Funciona y carga la lista
		shoppingCart.stream().forEach(product -> listStrings.add(product.name));
		
		System.out.println("Tamaño de la nueva lista con los nombres de los productos: " + listStrings.size());
		System.out.println(" ");	
		
		System.out.println("---------------Mostrar la lista (forEach)----------------------");
		listStrings.stream().forEach(t -> System.out.println(t));
		
		System.out.println("---------------Mostrar la lista (forEachOrdered)---------------------");
		listStrings.stream().forEachOrdered(t -> System.out.println(t));	
		System.out.println(" ");	
		
		System.out.println("---------------Mostrar la lista en linea con delimitadores-------");		
		String listaProductos = listStrings.stream().collect(Collectors.joining(",", "Productos: ", "."));
		System.out.println(listaProductos);
		System.out.println(" ");		
		
		System.out.println("---------------Mostrar la lista ordenada--------------");		
		listStrings.stream().sorted().forEach(t -> System.out.println(t));
		System.out.println(" ");	
		
		/*
		 * Ejemplo para aplicar los impuestos
		 */
		
		
		
		//lista con todos los precios
		List<BigDecimal> listaPrecioTotal = shoppingCart.stream().map(product -> product.price).toList();
		
		//sumar el precio total
		//BigDecimal precioTotal = shoppingCart.stream().map(product -> product.price);		
		//System.out.println("El precio total sin impuestos es :" + precioTotal);
		
		BigDecimal result = shoppingCart.stream()
				.map(product -> product.price.add(
						product.price.multiply(new BigDecimal(product.tax.percent).divide(new BigDecimal(100)))))
				.reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
					
		System.out.println("El resultado de aplicar impuestos es: " + result.toString() + "€");

		

		/*
		 * product es el tipo de elemento que tiene la lista, si queremos transformar el dato hay que mapearlo.
		 */
		
		String result2 = shoppingCart.stream().filter(product -> product.name.startsWith("C"))
				.map(product -> product.name)
				.collect(Collectors.joining(", ", "Resultado: ", "."));
		
		System.out.println("Los nombres de los productos que empiezan por C. " + result2);
				

	}

}
