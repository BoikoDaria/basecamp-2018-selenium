package tests

import objects.ClassicCalculatorPage
import objects.Keys
import ru.yandex.qatools.allure.annotations.Features
import ru.yandex.qatools.allure.annotations.Stories
import spock.lang.Shared
import spock.lang.Unroll

class CalculatorSpec extends BaseSpec {
    def setupSpec() {
        c_calc.open();
    }

    def "My Super test for calculator"() {
        given:
        c_calc.clear()

        when:
        c_calc.click_4()
        c_calc.click_2()
        c_calc.click_plus()
        c_calc.click_2()
        c_calc.click_equal()

        then:
        c_calc.getResult() == '44'

    }

    @Unroll
    def "Test #expression = #expected"() {
        given:
        calc.clear()

        expect:
        calc.calculate(expression) == expected

        where:
        expression            | expected
        "2+2"                 | "4"
        "20000000000000002+3" | "20000000000000005"
        "1+1"                 | "2"
        "-1-1"                | "-2"
        "0-1"                 | "-1"
        "1-0"                 | "1"
        "1/1"                 | "1"
        "1x1"                 | "1"
        "1.01+1.02"           | "2.03"
        "12563272x21312.32"   | "267752473111.04"
    }
}
