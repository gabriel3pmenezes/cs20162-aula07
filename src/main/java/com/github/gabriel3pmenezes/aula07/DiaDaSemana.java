/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.gabriel3pmenezes.aula07;

/**
 *
 * Implementação do cálculo de dia da semana através das instruções de aula.
 *
 * Método para identificação do dia da semana de uma data observando sob todos
 * os aspectos de variáveis
 *
 */
public final class DiaDaSemana {

    /**
     * Construtor privado da classe DiaSemana.
     */
    private DiaDaSemana() {
    }

    /**
     * Constante para um mês com 31 dias.
     */
    public static final int MES31DIAS = 31;

    /**
     * Constante para um mês com 30 dias.
     */
    public static final int MES30DIAS = 30;

    /**
     * Constante para o mês de fevereiro com 29 dias.
     */
    public static final int FEV29DIAS = 29;

    /**
     * Constante para mês de fevereiro com 28 dias.
     */
    public static final int FEV28DIAS = 28;

    /**
     * Tamanho máximo para a String correspondente à data.
     */
    public static final int TAMANHO_STRING_DA_DATA = 8;

    /**
     * Posição onde começa a String contendo o dia.
     */
    public static final int DIA = 6;

    /**
     * Posição onde começa a String contendo o mês.
     */
    public static final int INICIO_MES = 4;

    /**
     * Posição onde termina a String contendo o mês.
     */
    public static final int FINAL_MES = 6;

    /**
     * Posição onde começa a String contendo o ano.
     */
    public static final int INICIO_ANO = 0;

    /**
     * Posição onde termina a String contendo o ano.
     */
    public static final int FINAL_ANO = 4;

    /**
     * Dia da semana máximo, com domingo correspondente ao numero 6.
     */
    public static final int DIA_SEM_MAX = 6;

    /**
     * Período em anos entre dois anos bissextos.
     */
    public static final int PROX_BISSEXTO = 4;

    /**
     * Numero identificador do mês de Janeiro.
     */
    public static final int JANEIRO = 1;

    /**
     * Numero identificador do mês de Março.
     */
    public static final int MARCO = 3;

    /**
     * Numero identificador do mês de Abril.
     */
    public static final int ABRIL = 4;

    /**
     * CNumero identificador do mês de Maio.
     */
    public static final int MAIO = 5;

    /**
     * Numero identificador do mês de Junho.
     */
    public static final int JUNHO = 6;

    /**
     * Numero identificador do mês de Julho.
     */
    public static final int JULHO = 7;

    /**
     * CNumero identificador do mês de Agosto.
     */
    public static final int AGOSTO = 8;

    /**
     * Numero identificador do mês de Setembro.
     */
    public static final int SETEMBRO = 9;

    /**
     * Numero identificador do mês de Outubro.
     */
    public static final int OUTUBRO = 10;

    /**
     * Numero identificador do mês de Novembro.
     */
    public static final int NOVEMBRO = 11;

    /**
     * Numero identificador do mês de Dezembro.
     */
    public static final int DEZEMBRO = 12;

    /**
     * Numero máximo de dias que uma semana contém.
     */
    public static final int TAM_MAX_SEMANA = 7;

    /**
     * Número que indica quando a semana avançou.
     */
    public static final int PROXIMA_SEMANA = 7;

    /**
     * Número que indica o começo de uma demana; (domingo).
     */
    public static final int SEMANA_ANTERIOR = 6;

    /**
     * Obtém dia da semana para a data; Possui funções auxiliares.
     *
     * @param dataDeTeste Data a qual queremos descobrir o dia da semana
     * correspondente. Formato: aaaammdd;
     * @param anoBissexto Ano bissexto de referência;
     * @param dataConhecida Data de referência. Formato: aaaammdd;
     * @param diaSemanaConhecido Dia da semana correspondente da Data de
     * referência. Sendo 0 para Segunda, 1 para Terça... e 6 para Domingo.
     *
     * @return Valor -1 para irregularidades nos dados. Valor de 0 a 6
     * (inclusive) referente ao dia da semana da data desejada de acordo com os
     * dados de referência. OBS.: Pode não corresponder à realidade.
     *
     */
    public static int diaDaSemana(final int dataDeTeste, final int anoBissexto,
            final int dataConhecida, final int diaSemanaConhecido) {

        String data1 = Integer.toString(dataDeTeste);
        int dia1 = Integer.parseInt(data1.substring(DIA));
        int mes1 = Integer.parseInt(data1.substring(INICIO_MES, FINAL_MES));
        int ano1 = Integer.parseInt(data1.substring(INICIO_ANO, FINAL_ANO));

        String data2 = Integer.toString(dataConhecida);
        int dia2 = Integer.parseInt(data2.substring(DIA));
        int mes2 = Integer.parseInt(data2.substring(INICIO_MES, FINAL_MES));
        int ano2 = Integer.parseInt(data2.substring(INICIO_ANO, FINAL_ANO));

        if (data1.length() != TAMANHO_STRING_DA_DATA) {
            return -1;
        }

        if (data2.length() != TAMANHO_STRING_DA_DATA) {
            return -1;
        }

        if (!validarData(dia1, mes1, ano1, anoBissexto)) {
            return -1;
        }

        if (!validarData(dia2, mes2, ano2, anoBissexto)) {
            return -1;
        }

        if (anoBissexto <= 0) {
            return -1;
        }

        if (diaSemanaConhecido < 0 || diaSemanaConhecido > DIA_SEM_MAX) {
            return -1;
        }

        if (dataDeTeste == dataConhecida) {
            return diaSemanaConhecido;
        }

        int diasTotais;

        if (ordemCrescente(ano1, ano2, mes1, mes2, dia1, dia2)) {
            diasTotais = diferencarEmDias(ano2, ano1, mes2, mes1, dia2, dia1,
                    anoBissexto);
            return somaDiaSemana(diasTotais, diaSemanaConhecido);

        } else {
            diasTotais = diferencarEmDias(ano1, ano2, mes1, mes2, dia1, dia2,
                    anoBissexto);
            return diminuiDiaSemana(diasTotais, diaSemanaConhecido);

        }

    }

    /**
     * Verificação do ano bissexto
     *
     * @param anoParaTeste ano para verificação;
     * @param anoReferencia ano bissexto de referencia.
     * @return true para ano bissexto.
     */
    public static boolean verificarBissexto(final int anoParaTeste,
            final int anoReferencia) {
        if (anoParaTeste == anoReferencia) {
            return true;
        }

        if (anoParaTeste > anoReferencia) {
            for (int i = anoParaTeste; i >= anoReferencia; i -= PROX_BISSEXTO) {
                if (i == anoReferencia) {
                    return true;
                }
            }

        } else {
            for (int i = anoParaTeste; i <= anoReferencia; i += PROX_BISSEXTO) {
                if (i == anoReferencia) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verificação da validade da data inserida
     *
     * @param dia dia do teste;
     * @param mes mes do teste;
     * @param ano ano do teste;
     * @param anoBissexto de referência.
     * @return true para data valida.
     */
    public static boolean validarData(final int dia, final int mes,
            final int ano, final int anoBissexto) {
        if (mes < JANEIRO || mes > DEZEMBRO) {
            return false;
        }

        int quantidadeDias;
        quantidadeDias = diasPorMes(mes, ano, anoBissexto);

        return !(dia < 1 || dia > quantidadeDias);
    }

    /**
     * Verificação da quantidade de dias do mes referente
     *
     * @param mes o mes correspondente;
     * @param ano o ano correspondente.
     * @param anoBissexto de referência.
     * @return quantidade de dias por mês.
     */
    public static int diasPorMes(final int mes, final int ano,
            final int anoBissexto) {

        switch (mes) {
            case JANEIRO:
            case MARCO:
            case MAIO:
            case JULHO:
            case AGOSTO:
            case OUTUBRO:
            case DEZEMBRO:
                return MES31DIAS;
            case ABRIL:
            case JUNHO:
            case SETEMBRO:
            case NOVEMBRO:
                return MES30DIAS;
            default:
                if (verificarBissexto(ano, anoBissexto)) {
                    return FEV29DIAS;
                } else {
                    return FEV28DIAS;
                }
        }

    }

    /**
     * Verificação da quantidade de dias corridos entre as datas
     *
     * @param anoInicial ano da data menor;
     * @param anoFinal ano da data maior;
     * @param mesInicial mes da data menor;
     * @param mesFinal mes da data maior;
     * @param diaInicial dia da data menor;
     * @param diaFinal dia da data maior;
     * @param bissexto para referência.
     * @return numero de dias passados entre duas datas.
     */
    public static int diferencarEmDias(final int anoInicial, final int anoFinal,
            final int mesInicial, final int mesFinal, final int diaInicial,
            final int diaFinal, final int bissexto) {

        int dias = 0;
        int dia = diaInicial;
        int mes = mesInicial;
        int ano = anoInicial;

        do {
            dias++;
            dia++;

            if (dia > diasPorMes(mes, ano, bissexto)) {
                dia = 1;
                mes++;

                if (mes > DEZEMBRO) {
                    mes = 1;
                    ano++;
                }
            }

        } while (!testeDataIgual(ano, anoFinal, mes, mesFinal,
                dia, diaFinal));

        return dias;
    }

    /**
     * Teste da igualdade das datas
     *
     * @param anoInicial ano da primeira data;
     * @param anoFinal ano da ultima data;
     * @param mesInicial mes da primeira data;
     * @param mesFinal mes da ultima data;
     * @param diaInicial dia da primeira data;
     * @param diaFinal dia da ultima data.
     * @return true para datas iguais.
     */
    public static boolean testeDataIgual(final int anoInicial,
            final int anoFinal, final int mesInicial, final int mesFinal,
            final int diaInicial, final int diaFinal) {

        boolean test = true;

        if (diaInicial != diaFinal) {
            test = false;
        }
        if (mesInicial != mesFinal) {
            test = false;
        }
        if (anoInicial != anoFinal) {
            test = false;
        }

        return test;
    }

    /**
     * Verificação da maioridade da data inicial
     *
     * @param anoInicial ano da primeira data;
     * @param anoFinal ano da ultima data;
     * @param mesInicial mes da primeira data;
     * @param mesFinal mes da ultima data;
     * @param diaInicial dia da primeira data;
     * @param diaFinal dia da ultima data.
     * @return true para data inicial maior que a final.
     */
    public static boolean ordemCrescente(final int anoInicial,
            final int anoFinal, final int mesInicial, final int mesFinal,
            final int diaInicial, final int diaFinal) {

        if (anoInicial == anoFinal) {
            if (mesInicial == mesFinal) {
                return diaInicial > diaFinal;
            } else {
                return mesInicial > mesFinal;
            }
        } else {
            return anoInicial > anoFinal;
        }

    }

    /**
     * Soma de dias para encontrar o dia da semana
     *
     * @param diasTot entre duas datas;
     * @param diaSemanaConhecido dia da semana para referência.
     * @return Dia da semana desejado.
     */
    public static int somaDiaSemana(final int diasTot,
            final int diaSemanaConhecido) {
        int x = diasTot % TAM_MAX_SEMANA;
        int ds = diaSemanaConhecido;

        for (int i = 0; i < x; i++) {
            ds++;

            if (ds == PROXIMA_SEMANA) {
                ds = 0;
            }
        }
        return ds;
    }

    /**
     * Subtração de dias para encontrar o dia da semana
     *
     * @param diasTot entre duas datas;
     * @param diaSemanaConhecido dia da semana para referência.
     * @return Dia da semana desejado.
     */
    public static int diminuiDiaSemana(final int diasTot,
            final int diaSemanaConhecido) {
        int x = diasTot % TAM_MAX_SEMANA;
        int ds = diaSemanaConhecido;

        for (int i = 0; i < x; i++) {
            ds--;

            if (ds == -1) {
                ds = SEMANA_ANTERIOR;
            }
        }
        return ds;
    }

}
