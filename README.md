#  Calculadora de latencia
Programa que calcula la latencia final de un punto A a un punto B.

## Modo de uso

`$> Java CalculadoraLatencia.java archivo.cfg`


------------
## Archivos .cfg

Formato de archivo extención **.cfg**
```
#Nodos, #enlaces
{
//Para N nodos
...
Nodo, tiempoCola(segundos)
...
}
{
//Para N enlaces
...
NodoOrigen, NodoDestino, VelocidadEnlace(Mbps), Distancia(Metros),DC(Datos de control bytes), DU(Datos de usuario bytes)
...
}
TamPaquete(GBytes)
NodoOrigen, NodoDestino
```
