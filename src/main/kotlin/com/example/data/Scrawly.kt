package com.example.data
import com.google.gson.Gson
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import kotlinx.serialization.Serializable

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit


class Scrawly {
    
    fun main() {
        System.setProperty("webdriver.gecko.driver", """C:\geckodriver.exe""")
        val driver = FirefoxDriver()
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


        driver.findElementByXPath("/html/body/app-root/div/ms-navigation/div/div/app-home-login/div/div/div[3]/div[2]/div[2]/div[2]/a").click()
        Thread.sleep(1500)

        driver.findElement(By.id("username-txt")).click()
        driver.findElement(By.id("username-txt")).sendKeys("510217")
        driver.findElement(By.id("password-txt")).click()
        driver.findElement(By.id("password-txt")).sendKeys("Soleil12+")

        val wait = WebDriverWait(driver, 8)
        driver.findElementByXPath("/html/body/app-root/div/ms-navigation/div/div/app-home-login/div/div/div[3]/div[2]/ms-form/form/dx-validation-group/div[2]/ms-button/div/ms-default-button/button")
            .click()
        waitUntilPageIsReady(driver)
        Thread.sleep(4000)
        println(driver.currentUrl)
        ModuleIterator(driver)
        Thread.sleep(2000)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.findElementByXPath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/ul/li[2]").click()
        } catch(e : org.openqa.selenium.NoSuchElementException) {
            Thread.sleep(1000)
            println("hi there")
                driver.findElementByXPath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/ul/li[2]").click()
        }
        Thread.sleep(2000)
        file.writeText("""[""")
        val thread = Thread()
        try {
            tableIterator(driver)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            try {
                driver.findElementByXPath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]")
                    .click()
                tableIterator(driver)
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                println(e.message)
            }
        }
        Thread.sleep(1000)
        file.appendText("]\n")

    }

    private fun ModuleIterator(driver: FirefoxDriver) {
        val list = driver.findElementsByTagName("span")

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


    fun logMeIn(driver: FirefoxDriver, login: Login) {
        driver.get(login.url)
        driver.findElementById(login.username_id).sendKeys(login.username)
        driver.findElementById(login.password_id).sendKeys(login.password)
    }


    fun waitUntilPageIsReady(driver: FirefoxDriver) {
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

    fun lastShift(driver: FirefoxDriver) {
        driver.findElementByXPath("/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[2]/div[2]/div/div/h2").text

    }


    fun tableIterator(driver: FirefoxDriver) {
        val gson = Gson()
        var i = 0
        for (i in 3..30) {
            var table = Table(
                i,
                "/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[$i]/div/div[3]/div",
                "/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[$i]/div/div[4]/div/b",
                "/html/body/ng-include/div/div/div/div[2]/ui-view/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[$i]/div/div[6]/div",
            )
            println(driver.findElementByXPath(table.date).text)
            println(driver.findElementByXPath(table.job).text)
            println(driver.findElementByXPath(table.hours).text)
            file.appendText(
                    gson.toJson(
                        Shift(
                            driver.findElementByXPath(table.date).text,
                            driver.findElementByXPath(table.job).text,
                            driver.findElementByXPath(table.hours).text
                        )
                    ) + ","
                )
            Thread.sleep(50)

        }
    }
    fun hemingway() {
        file.appendText("mamamia0",charset("UTF-8"))

        file.appendText(Gson().toJson(Shift("in holy fuck 5 hours", "Post 10", "6:30-14h-00")))
    }

    companion object {
        val file = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")
    }
    
}
