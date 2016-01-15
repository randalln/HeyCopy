
import com.heywire.heycopy.Platform
import com.heywire.heycopy.Product

class BootStrap {

    def init = { servletContext ->
        new Platform(name:'All').save()
        new Platform(name:'Android').save()
        new Platform(name:'iOS').save()

        new Product(name:'All').save()
        //new Product(name:'ANOTHER_PRODUCT').save()
    }
    def destroy = {
    }
}
