package jugueteriaTest;

import com.ecodeup.model.Juguete;
import com.ecodeup.model.TipoJuguete;
import com.ecodeup.service.Tienda;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TiendaTest {

    private Tienda tienda;

    @Before
    public void setUp() {
        tienda = new Tienda("Mi Tienda");
    }

    @Test
    public void agregarJugueteTest() {
        Juguete juguete = new Juguete("Carro", TipoJuguete.MASCULINO, 10.0, 1);
        Juguete juguete1 = new Juguete("Muñueca",TipoJuguete.FEMENINO,20.0,3);
        tienda.agregarJuguete(juguete);
        tienda.agregarJuguete(juguete1);
        Assert.assertEquals(2, tienda.cantidadTotalJuguetes());
    }

    @Test
    public void contarJuguetesPorTipoTest() {
        Juguete juguete1 = new Juguete("Carro", TipoJuguete.MASCULINO, 10.0,  1);
        Juguete juguete2 = new Juguete("Muñeca", TipoJuguete.FEMENINO, 5.0,  2);
        tienda.agregarJuguete(juguete1);
        tienda.agregarJuguete(juguete2);
        Assert.assertEquals(1, tienda.contarJuguetesPorTipo(TipoJuguete.MASCULINO));
        Assert.assertEquals(1, tienda.contarJuguetesPorTipo(TipoJuguete.FEMENINO));
    }

    @Test
    public void cantidadTotalJuguetesTest() {
        Juguete juguete1 = new Juguete("Carro", TipoJuguete.MASCULINO, 10.0, 1);
        Juguete juguete2 = new Juguete("Muñeca", TipoJuguete.FEMENINO, 5, 2);
        tienda.agregarJuguete(juguete1);
        tienda.agregarJuguete(juguete2);
        Assert.assertEquals(2, tienda.cantidadTotalJuguetes());
    }

    @Test
    public void valorTotalJuguetesTest() {
        Juguete juguete1 = new Juguete("Carro", TipoJuguete.MASCULINO, 10, 10);
        Juguete juguete2 = new Juguete("Muñeca", TipoJuguete.FEMENINO, 5, 2);
        tienda.agregarJuguete(juguete1);
        tienda.agregarJuguete(juguete2);
        double expectedTotal = (10 * 10) + (5 * 2);
        Assert.assertEquals(expectedTotal, tienda.valorTotalJuguetes(), 0.01);
    }

}


