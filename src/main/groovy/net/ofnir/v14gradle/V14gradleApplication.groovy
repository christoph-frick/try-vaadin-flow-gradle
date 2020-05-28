package net.ofnir.v14gradle

import com.vaadin.flow.component.Composite
import com.vaadin.flow.component.Text
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import com.vaadin.flow.spring.annotation.EnableVaadin
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Service

@SpringBootApplication
@EnableVaadin
class V14gradleApplication {

    static void main(String[] args) {
        SpringApplication.run(V14gradleApplication, args)
    }

}

@Service
class HelloService {
    String sayHello(String to) { "Hello, ${to ?: "World"}" }
}

@Route("")
@Theme(value = Lumo)
class MainView extends Composite<Div> {
    MainView(HelloService lolService) {
        TextField tf = new TextField().tap {
            placeholder = "enter name to greet"
        }
        Button b = new Button("Greet!").tap {
            addClickListener {
                content.add(new Div(new Text(lolService.sayHello(tf.value))))
            }
        }
        content.add(new H1("Greetings!"))
        content.add(new FormLayout(tf, b))
    }
}
