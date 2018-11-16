# Fractal
Basic Julia and Mandelbrot fractal implementation using Java. 
Use intellij to open the project or 
Compile java file inside the src folder using "javac *.java".
For run the project as Following
"java Main Mandelbrot -0.5"
(0.5 -0.1 1 1000 means the region of interest for the image should be from -0.5<real<0.5 and
-0.1<complex<1 and for each point you need to do 1000 iterations before deciding that it is in the set.
Note that Main is the name of the application)
"java Main Julia -0.5 0.156 1000"
(then it plot the Julia set for C = -0.5 + 0.156i with 1000 iterations for each point.)
