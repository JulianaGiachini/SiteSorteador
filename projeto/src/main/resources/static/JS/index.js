$(document).ready(function () { //$('html').html(data)
    $("#btnSortear").click(function () {
        var quantidade = $("#quantidade").val();
        var inicio = $("#inicio").val();
        var fim = $("#fim").val();
        var check1 = $("#check1").is(":checked");
        var check2 = $("#check2").is(":checked");

        $.ajax({
            type: "POST", // Tipo da requisição
            url: "/resultado", // Caminho para envio da requisição
            data: { quantidade: quantidade, inicio: inicio, fim: fim , check1: check1, check2: check2},
            success: function (data) {
                $("#errorMessage").text("");
                if (data.sucesso) {
                    $("#resultado").text(data);
                    window.location.href = "/resultado";
                } else {
                    $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
                }
            },
            error: function () {
                $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
            },
        });
    });
});