## Escuela Colombiana de Ingeniería

## Arquitecturas de Software

# Componentes y conectores - Parte I.

El ejercicio se debe traer terminado para el siguiente laboratorio (Parte II).

#### Middleware- gestión de planos.


## Antes de hacer este ejercicio, realice [el ejercicio introductorio al manejo de Spring y la configuración basada en anotaciones](https://github.com/ARSW-ECI/Spring_LightweightCont_Annotation-DI_Example).

En este ejercicio se va a construír un modelo de clases para la capa lógica de una aplicación que permita gestionar planos arquitectónicos de una prestigiosa compañia de diseño. 

![](img/ClassDiagram1.png)

1. Configure la aplicación para que funcione bajo un esquema de inyección de dependencias, tal como se muestra en el diagrama anterior.


	Lo anterior requiere:

	* Agregar las dependencias de Spring.
	* Agregar la configuración de Spring.
	* Configurar la aplicación -mediante anotaciones- para que el esquema de persistencia sea inyectado al momento de ser creado el bean 'BlueprintServices'.

	Para este punto se agregó la etiqueta **@Autowired** en el objeto declarado BlueprintsPersistence en BlueprintsServices. Para la inyección agregamos la etiqueta **@Component** en la clase **InMemoryBlueprintPersistence**.

2. Complete los operaciones getBluePrint() y getBlueprintsByAuthor(). Implemente todo lo requerido de las capas inferiores (por ahora, el esquema de persistencia disponible 'InMemoryBlueprintPersistence') agregando las pruebas correspondientes en 'InMemoryPersistenceTest'.
	
	Clase: 

	![](img/inmemory.png)

	Pruebas:

	![](img/prueba1.png)


3. Haga un programa en el que cree (mediante Spring) una instancia de BlueprintServices, y rectifique la funcionalidad del mismo: registrar planos, consultar planos, registrar planos específicos, etc.

![](img/pruebaMain.png)


4. Se quiere que las operaciones de consulta de planos realicen un proceso de filtrado, antes de retornar los planos consultados. Dichos filtros lo que buscan es reducir el tamaño de los planos, removiendo datos redundantes o simplemente submuestrando, antes de retornarlos. Ajuste la aplicación (agregando las abstracciones e implementaciones que considere) para que a la clase BlueprintServices se le inyecte uno de dos posibles 'filtros' (o eventuales futuros filtros). No se contempla el uso de más de uno a la vez:
    * (A) Filtrado de redundancias: suprime del plano los puntos consecutivos que sean repetidos.
    * (B) Filtrado de submuestreo: suprime 1 de cada 2 puntos del plano, de manera intercalada.

    Para agregar el proceso de filtrado se agregó un nuevo paquete para los filtros. En este se tiene la interfaz BlueprintsFilters. Para los dos tipos de filtro se crearon las clases RedundancyFilter y SubsamplingFilter.
    En cada una de las clases se implementaron los métodos filterBlueprint y filterBlueprints, el primero filtra un solo plano y lo retorna y el segundo recibe una lista de planos, los filtra y los retorna.


    Prueba Filtrado (A):

![](img/testRedundancy.png) 

    Prueba Filtrado (B):

![](img/testSubsamplig.png)

5. Agregue las pruebas correspondientes a cada uno de estos filtros, y pruebe su funcionamiento en el programa de prueba, comprobando que sólo cambiando la posición de las anotaciones -sin cambiar nada más-, el programa retorne los planos filtrados de la manera (A) o de la manera (B). 

Filtrado (A):

![](img/mainRedundancy.png) 

Filtrado (B):

![](img/mainSubsampling.png) 




