package com.github.gabriel3pmenezes.aula07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.Assert;
import org.junit.Test;

public class DiaDaSemanaTest {

    @Test
    public void dataMenorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(2010101, 2016, 20161005,
                2));
    }

    @Test
    public void dataMaiorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(100000101, 2016, 20161005,
                2));
    }

    @Test
    public void dataMesMaiorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161301, 2016, 20161005,
                2));
    }

    @Test
    public void dataMesMenorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20160001, 2016, 20161005,
                2));
    }

    @Test
    public void dataDiaInvalidaSetembro() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20160931, 2016, 20161005,
                2));
    }

    @Test
    public void dataDiaInvalidaFevereiro() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20150229, 2016, 20161005,
                2));
    }

    @Test
    public void dataDiaIgualAZero() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20160900, 2016, 20161005,
                2));
    }

    @Test
    public void dataSemanaMenorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 2010101,
                2));
    }

    @Test
    public void dataSemanaMaiorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 100000101,
                2));
    }

    @Test
    public void dataSemanaMesMaiorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 20161301,
                2));
    }

    @Test
    public void dataSemanaMesMenorQueValida() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 20160001,
                2));
    }

    @Test
    public void dataDiaInvalidaOutubro() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 20161032,
                1));
    }

    @Test
    public void dataSemanaDiaInvalidaFevereiro() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 20150229,
                2));
    }

    @Test
    public void dCdiaIgualAZero() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20161005, 2016, 20160900,
                2));
    }

    @Test
    public void bissextoIgualAZero() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20151005, 0, 20161005,
                2));
    }

    @Test
    public void bissextoNegativo() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20151005, -100, 20161005,
                2));
    }

    @Test
    public void bissextoValidoDTMaior() {
        Assert.assertEquals(2, DiaDaSemana.diaDaSemana(20161005, 2012, 20151005,
                0));
    }

    @Test
    public void bissextoValidoDCMaior() {
        Assert.assertEquals(2, DiaDaSemana.diaDaSemana(20161005, 2012, 20171005,
                3));
    }

    @Test
    public void bissextoMaiorQueAData() {
        Assert.assertEquals(3, DiaDaSemana.diaDaSemana(20121010, 2020, 20121005,
                5));
    }

    //Testes com o dia da semana
    @Test
    public void diaSemanaNegativo() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20151005, 2016, 20161005,
                -1));
    }

    @Test
    public void diaSemanaMaiorQueSeis() {
        Assert.assertEquals(-1, DiaDaSemana.diaDaSemana(20151005, 2016, 20161005,
                7));
    }

    @Test
    public void datasIguais() {
        Assert.assertEquals(2, DiaDaSemana.diaDaSemana(20161005, 2016, 20161005,
                2));
    }

    @Test
    public void dataTesteMaiorAnoDiferente() {
        Assert.assertEquals(2, DiaDaSemana.diaDaSemana(20161005, 2016, 20151005,
                0));
    }

    @Test
    public void dataConhecidaMaiorAnoDiferente() {
        Assert.assertEquals(0, DiaDaSemana.diaDaSemana(20151005, 2016, 20161005,
                2));
    }

    @Test
    public void dataTesteMaiorMesmoAno() {
        Assert.assertEquals(5, DiaDaSemana.diaDaSemana(20161015, 2016, 20161005,
                2));
    }

    @Test
    public void dataConhecidaMaiorMesmoAno() {
        Assert.assertEquals(2, DiaDaSemana.diaDaSemana(20161005, 2016, 20161015,
                5));
    }

    @Test
    public void MesmoAnoMesesDiferentesDCMaior() {
        Assert.assertEquals(1, DiaDaSemana.diaDaSemana(19980113, 2000, 19981121,
                5));
    }

    @Test
    public void MesmoAnoMesesDiferentesDTMaior() {
        Assert.assertEquals(5, DiaDaSemana.diaDaSemana(19981121, 2000, 19980113,
                1));
    }

    @Test
    public void testaFuncaoSomaDiaSemana() {
        Assert.assertEquals(1, DiaDaSemana.diaDaSemana(20160712, 2016, 20161007,
                4));
    }

    @Test
    public void testaFuncaoDiminuiDiaSemana() {
        Assert.assertEquals(2, DiaDaSemana.diaDaSemana(20161005, 2016, 20161011,
                1));
    }

    @Test
    public void testaFuncaotesteDataIgual() {
        Assert.assertTrue(DiaDaSemana.testeDataIgual(2016, 2016, 10, 10, 10, 10));
    }

    @Test
    public void testaFuncaobissexto() {
        Assert.assertTrue(DiaDaSemana.verificarBissexto(2012, 2020));
    }

    @Test
    public void construtorPrivado() throws Exception {
        Constructor construtor = DiaDaSemana.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(construtor.getModifiers()));
        construtor.setAccessible(true);
        construtor.newInstance();
    }

}
