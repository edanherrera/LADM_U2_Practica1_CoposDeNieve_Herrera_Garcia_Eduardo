package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_herrera_garcia_eduardo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random


class Lienzo(este:MainActivity): View(este) {
    var este = este
    var scoope = CoroutineScope(Job() + Dispatchers.Main)
    var oCorutine = scoope.launch(EmptyCoroutineContext,CoroutineStart.LAZY){ }
    var oCorutine2 = scoope.launch(EmptyCoroutineContext,CoroutineStart.LAZY){ }
    var oCorutine3 = scoope.launch(EmptyCoroutineContext,CoroutineStart.DEFAULT){ }
    var circulos = Array<Circulos>(20,{Circulos(this@Lienzo)})
    var circulos2 = Array<Circulos>(150,{Circulos(this@Lienzo)})
    var tInicio = System.currentTimeMillis()
    var segundos = 0.0
    var tFinal =0.0
    override fun onDraw(c: Canvas) {

        super.onDraw(c)
        var p = Paint()

        //Creamos el fondo
        val fondo= Color.rgb(14,42,71)
        c.drawColor(fondo)

        //PASTO
        p.color = Color.rgb(95,122,46)
        c.drawRect(0f,895f,733f,1340f,p)

        //TEXT "PASSWORD"
        p.style = Paint.Style.FILL
        p.textSize = 30f
        p.color = Color.BLACK
        c.drawText("Tiempo: ${segundos}",130f,150f,p)

//---------------------------------------------------------------------- CASA ----------------------------------------------------------------------------
        //Creación de paredes
        p.color = Color.rgb(209,193,169)
        c.drawRect(300f,600f,700f,900f,p)

        //Dibujo de techo
        val co = IntArray(6)
        co[0] = Color.rgb(186,113,4)
        co[1] = Color.rgb(186,113,4)
        co[2] = Color.rgb(186,113,4)
        co[3] = Color.rgb(186,113,4)
        co[4] = Color.rgb(186,113,4)
        co[5] = Color.rgb(186,113,4)
        var verti= FloatArray(6)

        verti[0] = 500f//x centro
        verti[1] = 400f//y centro
        verti[2] = 700f//x der
        verti[3] = 600f//y der
        verti[4] = 300f//x izq
        verti[5] = 600f//y izq
        c.drawVertices(Canvas.VertexMode.TRIANGLES,verti.size,verti,0,
            null,0,co, 0, null, 0, 0,p)

        //Puerta
        p.color = Color.rgb(186,113,4)
        c.drawRect(450f,750f,550f,900f,p)
        p.color = Color.rgb(118,122,121)
        c.drawCircle(465f,815f,10f,p)

        //ventanas.
        p.color = Color.rgb(211,242,246)
        c.drawRect(325f,625f,425f,725f,p)

        c.drawRect(575f,625f,675f,725f,p)

        p.style = Paint.Style.STROKE
        p.strokeWidth = 5f
        p.color = Color.GRAY
        c.drawRect(325f,625f,425f,725f,p)
        c.drawRect(575f,625f,675f,725f,p)
        p.style = Paint.Style.FILL


//---------------------------------------------------------------------- BUZÓN ----------------------------------------------------------------------------
        p.color = Color.rgb(118,122,121)
        c.drawRect(275f,855f,325f,885f,p)

        p.color = Color.rgb(151,92,20)
        c.drawRect(295f,885f,305f,915f,p)

//---------------------------------------------------------------------- ÁRBOL ----------------------------------------------------------------------------
        //Dibujo arbol
        //tronco
        p.color = Color.rgb(151,92,20)
        c.drawRect(100f,500f,200f,900f,p)
        //hojas
        p.color = Color.rgb(139,195,74)
        c.drawOval(10f,450f,290f,550f,p)
        c.drawOval(30f,390f,270f,490f,p)
        c.drawOval(50f,330f,250f,430f,p)
        c.drawOval(70f,270f,230f,370f,p)
        c.drawOval(90f,220f,210f,320f,p)

        //nieve en el fondo
        if((segundos >15 && segundos<25) || (segundos >45) ){
            p.color = Color.WHITE
            //puerta
            c.drawLine(450f,750f,550f,750f,p)
            //Ventanas
            c.drawLine(325f,625f,425f,625f,p)
            c.drawLine(575f,625f,675f,625f,p)
            //buzón
            c.drawLine(275f,855f,325f,855f,p)
            //árbol
            c.drawOval(90f,220f,210f,240f,p)
            //techo
            c.drawLine(498f,400f,700f,600f,p)
            c.drawLine(500f,400f,300f,600f,p)
            //pasto
            p.color =Color.rgb(200, 211,181)
            c.drawRect(0f,895f,733f,1340f,p)
            //muñeco de nueve
            p.color = Color.WHITE
            c.drawCircle(200f,1200f,100f,p)
            c.drawCircle(200f,1100f,70f,p)
            c.drawCircle(200f,1010f,40f,p)
            p.color = Color.BLACK
            c.drawCircle(215f,995f,5f,p)
            c.drawCircle(185f,995f,5f,p)

            p.color = Color.rgb(255,87,34)
            c.drawCircle(205f,1005f,8f,p)

            p.color = Color.rgb(151,92,20)
            c.drawLine(130f,1100f,80f,1000f,p)
            c.drawLine(270f,1100f,320f,1000f,p)

            p.color = Color.BLACK
            c.drawRect(150f,960f,250f,980f,p)
            c.drawRect(170f,920f,230f,960f,p)
            p.color = Color.RED
            c.drawRect(170f,935f,230f,945f,p)
        }
        //-------------------------------------------------------------------- NEVADO ---------------------------------------------------------------------------------
        //oCorutine3 = scoope.launch(EmptyCoroutineContext,CoroutineStart.DEFAULT){

        if (segundos<10) {
            for (i in 0..circulos.size - 1) {
                p.color = circulos[i].color
                c.drawCircle(
                    circulos[i].cX.toFloat(),
                    circulos[i].cY.toFloat(),
                    circulos[i].radi.toFloat(), p)
            }
        }
        if(segundos>10.0 && segundos<19.0 ) {
            for (i in 0..circulos2.size - 1) {
                p.color = circulos2[i].color
                c.drawCircle(
                    circulos2[i].cX.toFloat(),
                    circulos2[i].cY.toFloat(),
                    circulos2[i].radi.toFloat(), p)
            }
        }
        if (segundos>30 && segundos<40) {
            for (i in 0..circulos.size - 1) {
                p.color = circulos[i].color
                c.drawCircle(
                    circulos[i].cX.toFloat(),
                    circulos[i].cY.toFloat(),
                    circulos[i].radi.toFloat(), p)
            }
        }
        if (segundos>40) {
            for (i in 0..circulos2.size - 1) {
                p.color = circulos2[i].color
                c.drawCircle(
                    circulos2[i].cX.toFloat(),
                    circulos2[i].cY.toFloat(),
                    circulos2[i].radi.toFloat(), p)
            }
        }
        //}
        nevadoLento()
        nevadoRapido()
        invalidate()
    }


    fun nevadoLento(){
        oCorutine.start()
        oCorutine = scoope.launch(EmptyCoroutineContext, CoroutineStart.LAZY) {
            tFinal = System.currentTimeMillis().toDouble()
            if (segundos<10) {
                for (i in 0..circulos.size - 1) {
                    if (circulos[i].cY > 1300.0) {
                        circulos[i].sentidoY = false
                    }
                    if (circulos[i].cY < 5.0) {
                        circulos[i].sentidoY = true
                    }

                    if (circulos[i].sentidoY) {
                        circulos[i].moverYD()
                    } else {
                        circulos[i].cY = 0.0
                    }
                }
            }
            if (segundos>30 && segundos<40) {
                for (i in 0..circulos.size - 1) {
                    if (circulos[i].cY > 1300.0) {
                        circulos[i].sentidoY = false
                    }
                    if (circulos[i].cY < 5.0) {
                        circulos[i].sentidoY = true
                    }

                    if (circulos[i].sentidoY) {
                        circulos[i].moverYD()
                    } else {
                        circulos[i].cY = 0.0
                    }
                }
            }
            tiempo()
            delay(300L)
        }

    }

    fun nevadoRapido(){
        oCorutine2.start()
        oCorutine2 = scoope.launch(EmptyCoroutineContext, CoroutineStart.LAZY) {
            tFinal = System.currentTimeMillis().toDouble()
            if(segundos>10.0 && segundos<19.0 ) {
                for (i in 0..circulos2.size - 1) {
                    if (circulos2[i].cY > 1300.0) {
                        circulos2[i].sentidoY = false
                    }
                    if (circulos2[i].cY < 5.0) {
                        circulos2[i].sentidoY = true
                    }

                    if (circulos2[i].sentidoY) {
                        circulos2[i].moverYD()
                    } else {
                        circulos2[i].cY = 0.0
                    }
                }
            }
            if(segundos>40.0) {
                for (i in 0..circulos2.size - 1) {
                    if (circulos2[i].cY > 1300.0) {
                        circulos2[i].sentidoY = false
                    }
                    if (circulos2[i].cY < 5.0) {
                        circulos2[i].sentidoY = true
                    }

                    if (circulos2[i].sentidoY) {
                        circulos2[i].moverYD()
                    } else {
                        circulos2[i].cY = 0.0
                    }
                }
            }
            tiempo()
            delay(300L)
        }


    }
    fun tiempo(){
        var tDiferencia = tFinal - tInicio
        segundos = tDiferencia/1000.0
    }

}




class Circulos(lienzo: Lienzo){
    var sentidoY = true
    val rgb1 = List(3) { Random.nextInt(0, 255) }
    val color = Color.WHITE
    val radi= Random.nextDouble(1.0,20.0)
    var cX= Random.nextDouble(5.0,708.0)
    var cY= Random.nextDouble(5.0,1300.0)
    val movY = Random.nextDouble(1.0,5.0)
    fun moverYU(){
        cY=cY-movY
    }
    fun moverYD(){
        cY=cY+movY
    }

}