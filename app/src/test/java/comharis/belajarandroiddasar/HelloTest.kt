package comharis.belajarandroiddasar

import org.junit.Assert
import org.junit.Test

class HelloTest {

    @Test
    fun testSayHello() {
        val result = Hello.sayHello("Haris")

        Assert.assertEquals("Hello Haris", result)
    }
}