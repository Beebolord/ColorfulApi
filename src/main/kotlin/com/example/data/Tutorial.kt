
import com.google.gson.Gson
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.BufferedWriter
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit


class Tutorial {
    fun alternate() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe")

        //Set Firefox Headless mode as TRUE

        //Set Firefox Headless mode as TRUE
        val options = FirefoxOptions()
        options.setHeadless(true)
        val driver: WebDriver = FirefoxDriver(options)
        driver["http://www.google.com"]
        println("Page title is - " + driver.title)

        //Search on Google

        //Search on Google
        driver.findElement(By.name("q")).sendKeys("selenium webdriver")
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER)
        println(driver.title)
        driver.quit()
    }
    fun main() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe")

        //Set Firefox Headless mode as TRUE

        //Set Firefox Headless mode as TRUE
        val options = FirefoxOptions()
        options.setHeadless(true)
        val driver: WebDriver = FirefoxDriver(options)

        val file = File("""C:\Users\ismae\IdeaProjects\ScrawlyAlpha\src\main\kotlin\file.json""")
        val github = Login(
            "https://github.com",
            "ismaelforest@gmail.com",
            "login_field",
            "Satan258069911!",
            "password"
        )
        val virtuo = Login(
            "https://virtuo.ciussscn.rtss.qc.ca/portals/home/app/login",
            "510217",
            "username-txt",
            "Satan258069911!",
            "password-txt",
        )
        //logMeIn(driver, virtuo)
        driver["https://virtuo.ciussscn.rtss.qc.ca/portals/home/app/login"]

        driver.manage().window().fullscreen()
        println(driver.title)
        Thread.sleep(1500)


        driver.findElement(By.xpath("/html/body/app-root/div/ms-navigation/div/div/app-home-login/div/div/div[3]/div[2]/div[2]/div[2]/a")).click()
        Thread.sleep(1500)

        driver.findElement(By.id("username-txt")).click()
        driver.findElement(By.id("username-txt")).sendKeys("510217")
        driver.findElement(By.id("password-txt")).click()
        driver.findElement(By.id("password-txt")).sendKeys("Satan258069911!")

        val wait = WebDriverWait(driver, 8)
        driver.findElement(By.xpath("""/html/body/app-root/div/ms-navigation/div/div/app-home-login/div/div/div[3]/div[2]/ms-form/form/dx-validation-group/div[2]/ms-button/div/ms-default-button/button""")).click()
        waitUntilPageIsReady(driver)
        Thread.sleep(4000)
        println(driver.currentUrl)
        ModuleIterator(driver)
        Thread.sleep(2000)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.findElement(By.xpath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/ul/li[2]")).click()
        } catch(e : org.openqa.selenium.NoSuchElementException) {
            Thread.sleep(4000)
            println("hi there")
            driver.findElement(By.xpath("""/html/body/ng-include/div/div/div/div[2]/ui-view/div/ul/li[2]""")).click()
        }
        Thread.sleep(2000)



        file.appendText("""[""")
        val thread = Thread()
        try {
            tableIterator(driver)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            try {
                driver.findElement(By.xpath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]"))
                    .click()
                tableIterator(driver)
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                println(e.message)
            }
        }
        Thread.sleep(1000)
        file.appendText("]\n")

    }

    private fun ModuleIterator(driver: WebDriver) {
        val list = driver.findElements(By.tagName("span"))

        for (i in list.indices) {
            println(list.get(i).text)
            println(list.get(i))
            println("$i \n")
            if (i == 34) {
                list[i].click()
                break
            }
        }
    }

    data class Login(
        val url: String,
        val username: String,
        val username_id: String,
        val password: String,
        val password_id: String
    )

    data class Shift(
        val date: String,
        val job: String,
        val hours: String,
    )


    fun logMeIn(driver: WebDriver, login: Login) {
        driver.get(login.url)
        driver.findElement(By.id(login.username_id)).sendKeys(login.username)
        driver.findElement(By.id(login.password_id)).sendKeys(login.password)
    }


    fun waitUntilPageIsReady(driver: WebDriver) {
        val executor = driver as JavascriptExecutor
        WebDriverWait(driver, 1)
            .until { executor.executeScript("return document.readyState") == "complete" }
    }

    data class Table(
        val row: Int,
        val date: String,
        val job: String,
        val hours: String,
    )

    fun findCurrent(): String {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY")
        val formatted = current.format(formatter)
        return formatted.toString()
    }

    fun lastShift(driver: WebDriver) {
        driver.findElement(By.xpath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[2]/div[2]/div/div/h2")).text

    }


    fun tableIterator(driver: WebDriver) {
        val gson = Gson()
        var i = 0
        for (i in 3..30) {
            var table = Table(
                i,
                "/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[$i]/div/div[3]/div",
                "/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[$i]/div/div[4]/div/b",
                "/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[$i]/div/div[6]/div",
            )
            println(driver.findElement(By.xpath(table.date)).text)
            println(driver.findElement(By.xpath(table.job)).text)
            println(driver.findElement(By.xpath(table.hours)).text)
            val bw = BufferedWriter(file.writer())
            Thread.sleep(500)
            file.appendText( driver.findElement(By.xpath(table.date)).text)
            file.appendText(
                gson.toJson(
                    Shift(
                        driver.findElement(By.xpath(table.date)).text,
                        driver.findElement(By.xpath(table.job)).text,
                        driver.findElement(By.xpath(table.hours)).text
                    )
                ) + ","
            )

        }
    }

    fun jsonFormatter() {
        val scanner = Scanner(file)
        var x = scanner.next("}")
        x = ""
        file.writeText(scanner.toString())
        file.appendText("}")
    }
    companion object {
        val file = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")
    }
}
