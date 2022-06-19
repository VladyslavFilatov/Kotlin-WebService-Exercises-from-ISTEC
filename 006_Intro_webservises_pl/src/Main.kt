import java.awt.Image
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel


fun main() {

    // tempo
    val key:String = "4f08b3b9ba4e9b4ff1a23f00639c7fb1"
    val  urlTempo:String = "http://api.weatherstack.com/current"
    val cidade:String = "Lisbon"

    //val resp = URL("${urlTempo}?access_key=${key}&query=${cidade}").readText()
    //println(resp)


    //memes
    val txtTop = "E+melhor+comecar"
    val txtBottom = "a+estudar.."
    val meme = "Advice-Yoda"

    val endPoint = "https://apimeme.com/meme"

    val urlMeme:String = "${endPoint}?meme=${meme}&top=${txtTop}&bottom=${txtBottom}"

    var imagem : Image? = null
    try {
        val  url = URL(urlMeme)
        imagem = ImageIO.read(url)
    } catch (e: IOException) {
        e.printStackTrace()
    }

    val frame = JFrame()
    frame.setSize(600, 600)
    var  label = JLabel(ImageIcon(imagem))
    frame.add(label)
    frame.isVisible = true

    println(urlMeme)



    val txtTop2 = "Hora+para+descancar"
    val txtBottom2 = "rapidamente"
    val meme2 = "Angry-Birds-Pig"

    val endPoint2 = "https://apimeme.com/meme"

    val urlMeme2:String = "${endPoint2}?meme=${meme2}&top=${txtTop2}&bottom=${txtBottom2}"

    var imagem2 : Image? = null
    try {
        val  url2 = URL(urlMeme2)
        imagem2 = ImageIO.read(url2)
    } catch (e: IOException) {
        e.printStackTrace()
    }

    val frame2 = JFrame()
    frame2.setSize(600, 600)
    var  label2 = JLabel(ImageIcon(imagem2))
    frame2.add(label2)
    frame2.isVisible = true


}