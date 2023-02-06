
<h1>Fragments</h1>

En esta tarea, hemos realizado un ejercicio para aplicar Fragments, en este caso con ViewModel en Kotlin, en Android Studio. Hemos creado una aplicación que
consiste en una Activity principal con un contenedor que contiene dos botones que llaman a los Fragments. Un botón es para un Fragment que multiplicará dos
números aleatorios y nos dará el resultado y otro botón para un Fragment que sumará dos números aleatorios y nos dará el resultado.

<h2>Main Activity</h2>

En nuestra MainActivity, hemos instanciado los botones de ambos Fragmentos, la suma y la multiplicación y una función que cambia de fragmento cada vez que 
pulsamos el respectivo botón. Hemos creado un Layaout principal con un contenedor para ambos botones y una parte de la pantalla donde nos aparecerá el respectivo
Fragmento al que llamemos. También hemos hecho el mismo layout pera en Landscape para que nos aparezca de la misma manera cuando ponemos el teléfono en horizontal.
A continuación muestro el código de los botones de los Fragmentos.

``` val suma: Button = findViewById(R.id.suma)
       val multiplicacion: Button = findViewById(R.id.multiplicacion)
       suma.setOnClickListener { replaceFragment(SumaFragment()) }

       multiplicacion.setOnClickListener { replaceFragment(MultiplicacionFragment()) }

```

A continuación muestro el código de la función para cambiar de Fragmento, dependiendo del botón pulsado.

```
private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
    }
```

<h2>View Model</h2>

En nuestro viewModel, es donde guardaremos los datos usados y las operaciones de cada uno de los Fragments. En él, instanciaremos las variables que vayamos a usar
y les asignaremos sus respectivos LiveData para que la información usada se almacene y se quede guardada para cuando usemos el ViewModel.


```
var random = (0..9).random()
    var random2 = (0..9).random()
    var resultado : Int = 0

    var liveRandom = MutableLiveData<Int>()
    var liveRandom2 = MutableLiveData<Int>()
    var liveResultado = MutableLiveData<Int>()

    init {
        liveRandom.value = random
    }

    init {
        liveRandom2.value = random2
    }
    init {
        liveResultado.value = resultado
    }
```
<h2>Fragments</h2>

Lo primero. ha sido crear los respectivos layouts de cada Fragment y lo cargaremos en el layout principal de la aplicaciEn nuestros Fragment es donde vamos a visualizar los numeros aleatorios y donde realizaremos las operaciones necesarias de cada uno. Para ello necesitaremos unos observadores para visualizar en el Fragment las variables aleatorias que hemos creado en el viewModel y para devolver el valor del resultado de vuelva al viewModel.
Esta clase tiene dos métodos, el onCreate y onCreateView. En esta primera clase es donde pondremos los observadores de las clases. Y en el onCreateView inicializaremos todos los componentes de la vista para que los recoja del layout.
A continuación muestro parte del código del onCreateView.
```
`override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_suma, container, false)
        val botonMulti: Button? = view.findViewById(R.id.suma)
        val resultadoText: TextView? = view.findViewById(R.id.sumaResultado)

        botonMulti?.setOnClickListener {
            viewModel.hacerSuma()
            resultadoText?.text = viewModel.resultado.toString()
        }
        return view

    }

```
Y muestro los observadores creados en el OnCreate del Fragment.

```
  val miModelo by viewModels<MainViewModel>()

        miModelo.liveRandom.observe(
            this,
            Observer(
                fun(random: Int) {
                    var tvRandom: TextView? = view?.findViewById(R.id.sumaRandom1)
                    tvRandom?.setText("$random")

                }
            )

        )
        miModelo.liveRandom2.observe(
            this,
            Observer(
                fun(random2: Int) {
                    var tvRandom2: TextView? = view?.findViewById(R.id.sumaRandom2)
                    tvRandom2?.setText("$random2")

                }
            )

        )

        miModelo.liveResultado.observe(
            this,
            Observer(
                fun(resultado: Int) {
                    var tvResultado: TextView? = view?.findViewById(R.id.sumaResultado)
                    tvResultado?.setText("$resultado")

                }
            )
        )

    }


```
<h2>Capturas de la Aplicación</h2>

CAPTURAS EN VERTICAL

![multi](https://user-images.githubusercontent.com/113973157/216925358-fd94f4e2-2d3a-4d0b-a952-31c6edda60df.png)

![suma](https://user-images.githubusercontent.com/113973157/216925338-872194fd-092c-4de6-8a4c-82b6e6d9bfb1.png)

CAPTURAS EN HORIZONTAL

![multiLand](https://user-images.githubusercontent.com/113973157/216925822-b1576302-2890-4e9e-8e65-f6b261bdb9ec.png)

![sumaLand](https://user-images.githubusercontent.com/113973157/216925879-90a90c90-a6f0-4545-a3c5-08770dbd68bd.png)



    
