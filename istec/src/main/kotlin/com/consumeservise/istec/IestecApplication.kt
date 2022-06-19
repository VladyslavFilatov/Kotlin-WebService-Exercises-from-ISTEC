package com.consumeservise.istec

import io.netty.util.internal.ThreadLocalRandom
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import java.awt.Image
import java.io.IOException
import java.net.URL
import java.time.Duration
import java.time.LocalDateTime
import javax.imageio.ImageIO


@SpringBootApplication
class IestecApplication

fun main(args: Array<String>) {
	runApplication<IestecApplication>(*args)

}

@RestController // Rest = протоколы/ Простоколы это правила связи
class ResyController {

	private fun randomStockPrice():Double {
		return ThreadLocalRandom.current().nextDouble(100.0)
	}

	// Websockets (exemplo)
	@GetMapping(value = ["/stocks/{symbol}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
	fun prices(@PathVariable symbol: String): Flux<StockPrice>{// @PathVariable - что-то типа нашего url
		return Flux.interval(Duration.ofSeconds(1)) //Flux типа данных которые передает нам данные класса
			.map { StockPrice(symbol,randomStockPrice(), LocalDateTime.now()) }
	}



	// HTTP-REST
	@GetMapping("/teste")
	fun myString(): String {
		return "ola boa noite!"
	}

	@PostMapping("/omeupost") // EndPoint
		fun myPost(): String{
			return "string do meu post!!"
		}

	@PostMapping(value = ["/myresponse"], consumes = ["application/json"]) // для совего EndPoint  я выбрал формат "тип языка" - json - xconsumes = ["application/json"]
	fun myResp(@RequestBody message: String) : String { // даем команду найти наше сообщение из Body нашего языка/сообщения - @RequestBody message: String
		return message + "xpto"

	}



	@GetMapping("/myteste")
	fun myImage(): ByteArray? {
		var icon: String = "https://openweathermap.org/img/wn/10d@2x.png"


		var imagem2 : Image? = null
		try {
			val  url2 = URL(icon)
			imagem2 = ImageIO.read(url2)
		} catch (e: IOException) {
			e.printStackTrace()
		}

		var  label2 : ByteArray? = imagem2.toString().toByteArray()

		return label2
	}



}

data class StockPrice(val symbol:String, val price: Double, val time:LocalDateTime)


