<!--<script type='text/javascript'>-->
    function fimApolice(el) {
        if (el.value === '6meses') {
            var data = new Date();
            var pagamento = new Date(data.getTime() + (180 * 24 * 60 * 60 * 1000));	// 6 meses seguintes
            var diaDaSemana = pagamento.getDay();					// dia da semana
            if (diaDaSemana == 1) {
                pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
            }
            if ((diaDaSemana == 6) || (diaDaSemana == 0)) {
                pagamento = new Date(pagamento.getTime() + (2 * 24 * 60 * 60 * 1000));
            }
            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();
            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            var dataAmanha = dia + "/" + mes + "/" + ano;

            var arrayFeriado = [];
            arrayFeriado.push(// array de feriados 
                    {data: '01/01/2019'}, {data: '25/01/2019'}, {data: '05/03/2019'}, {data: '19/04/2019'},
                    {data: '01/05/2019'}, {data: '20/06/2019'}, {data: '09/07/2019'}, {data: '15/11/2019'},
                    {data: '20/11/2019'}, {data: '25/12/2019'});

            for (var i = 0; i < arrayFeriado.length; i++) {
                if (arrayFeriado[i].data === dataAmanha) {
                    var existeFeriado = true;
                    break;
                }
            }

            if (existeFeriado == true) {
                if (diaDaSemana == 5) {
                    pagamento = new Date(pagamento.getTime() + (4 * 24 * 60 * 60 * 1000));
                } else {
                    pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
                }
            }

            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();

            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            dataAmanha = dia + "/" + mes + "/" + ano;

            document.getElementById('dataFutura').value = dataAmanha;

        } else if (el.value === '12meses') {
            var data = new Date();
            var pagamento = new Date(data.getTime() + (365 * 24 * 60 * 60 * 1000));	// 6 meses seguintes
            var diaDaSemana = pagamento.getDay();					// dia da semana
            if (diaDaSemana == 1) {
                pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
            }
            if ((diaDaSemana == 6) || (diaDaSemana == 0)) {
                pagamento = new Date(pagamento.getTime() + (2 * 24 * 60 * 60 * 1000));
            }
            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();
            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            var dataAmanha = dia + "/" + mes + "/" + ano;

            var arrayFeriado = [];
            arrayFeriado.push(// array de feriados 
                    {data: '01/01/2019'}, {data: '25/01/2019'}, {data: '05/03/2019'}, {data: '19/04/2019'},
                    {data: '01/05/2019'}, {data: '20/06/2019'}, {data: '09/07/2019'}, {data: '15/11/2019'},
                    {data: '20/11/2019'}, {data: '25/12/2019'});

            for (var i = 0; i < arrayFeriado.length; i++) {
                if (arrayFeriado[i].data === dataAmanha) {
                    var existeFeriado = true;
                    break;
                }
            }

            if (existeFeriado == true) {
                if (diaDaSemana == 5) {
                    pagamento = new Date(pagamento.getTime() + (4 * 24 * 60 * 60 * 1000));
                } else {
                    pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
                }
            }

            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();

            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            dataAmanha = dia + "/" + mes + "/" + ano;

            document.getElementById('dataFutura').value = dataAmanha;

        } else if (el.value === '18meses') {
            var data = new Date();
            var pagamento = new Date(data.getTime() + (545 * 24 * 60 * 60 * 1000));	// 18 meses seguintes
            var diaDaSemana = pagamento.getDay();					// dia da semana
            if (diaDaSemana == 1) {
                pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
            }
            if ((diaDaSemana == 6) || (diaDaSemana == 0)) {
                pagamento = new Date(pagamento.getTime() + (2 * 24 * 60 * 60 * 1000));
            }
            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();
            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            var dataAmanha = dia + "/" + mes + "/" + ano;

            var arrayFeriado = [];
            arrayFeriado.push(// array de feriados 
                    {data: '01/01/2019'}, {data: '25/01/2019'}, {data: '05/03/2019'}, {data: '19/04/2019'},
                    {data: '01/05/2019'}, {data: '20/06/2019'}, {data: '09/07/2019'}, {data: '15/11/2019'},
                    {data: '20/11/2019'}, {data: '25/12/2019'});

            for (var i = 0; i < arrayFeriado.length; i++) {
                if (arrayFeriado[i].data === dataAmanha) {
                    var existeFeriado = true;
                    break;
                }
            }

            if (existeFeriado == true) {
                if (diaDaSemana == 5) {
                    pagamento = new Date(pagamento.getTime() + (4 * 24 * 60 * 60 * 1000));
                } else {
                    pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
                }
            }

            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();

            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            dataAmanha = dia + "/" + mes + "/" + ano;

            document.getElementById('dataFutura').value = dataAmanha;

        } else if (el.value === '24meses') {
            var data = new Date();
            var pagamento = new Date(data.getTime() + (730 * 24 * 60 * 60 * 1000));	// 6 meses seguintes
            var diaDaSemana = pagamento.getDay();					// dia da semana
            if (diaDaSemana == 1) {
                pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
            }
            if ((diaDaSemana == 6) || (diaDaSemana == 0)) {
                pagamento = new Date(pagamento.getTime() + (2 * 24 * 60 * 60 * 1000));
            }
            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();
            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            var dataAmanha = dia + "/" + mes + "/" + ano;

            var arrayFeriado = [];
            arrayFeriado.push(// array de feriados 
                    {data: '01/01/2019'}, {data: '25/01/2019'}, {data: '05/03/2019'}, {data: '19/04/2019'},
                    {data: '01/05/2019'}, {data: '20/06/2019'}, {data: '09/07/2019'}, {data: '15/11/2019'},
                    {data: '20/11/2019'}, {data: '25/12/2019'});

            for (var i = 0; i < arrayFeriado.length; i++) {
                if (arrayFeriado[i].data === dataAmanha) {
                    var existeFeriado = true;
                    break;
                }
            }

            if (existeFeriado == true) {
                if (diaDaSemana == 5) {
                    pagamento = new Date(pagamento.getTime() + (4 * 24 * 60 * 60 * 1000));
                } else {
                    pagamento = new Date(pagamento.getTime() + (1 * 24 * 60 * 60 * 1000));
                }
            }

            var dia = pagamento.getDate();
            var mes = pagamento.getMonth();
            mes++;
            var ano = pagamento.getFullYear();

            if (dia < 10) {
                dia = "0" + dia;
            }
            if (mes < 10) {
                mes = "0" + mes;
            }

            dataAmanha = dia + "/" + mes + "/" + ano;

            document.getElementById('dataFutura').value = dataAmanha;

        }
    }
<!--</script>-->