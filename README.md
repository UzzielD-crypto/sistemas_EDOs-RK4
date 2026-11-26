# sistemas_EDOs-RK4
# RK4 vectorial: circuito RLC serie

Actividad Tema 6.3 – SCC-1017 Métodos Numéricos
Instituto Tecnológico Superior de Xalapa – Ingeniería en Sistemas Computacionales
Alumno: Uzziel David Castillo Gabriel
Docente: Víctor Hugo Vásquez Herrera

## Descripción

Implementación en Java del método de Runge-Kutta de 4to orden (RK4) en forma vectorial para resolver la respuesta libre de un circuito RLC serie con L = 1 H, R = 0.4 Ω y C = 1 F:

```
q'' + 0.4 q' + q = 0,   q(0) = 1.0,   q'(0) = 0.0
```

La EDO de segundo orden se reduce a un sistema de primer orden con y1 = q (carga) e y2 = q' (corriente):

```
y1' = y2
y2' = -0.4 y2 - y1
Y(0) = [1.0, 0.0]
```

El programa calcula 25 puntos después del inicial y los compara con la solución analítica exacta:

```
q_exacta(t)
