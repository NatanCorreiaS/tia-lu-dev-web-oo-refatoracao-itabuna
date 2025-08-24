@echo off
rem Compila todos os arquivos .java da pasta src para a pasta out
javac .\src\*.java -d .\out

rem Verifica se a compilação teve sucesso
if %ERRORLEVEL% NEQ 0 (
    echo Houve um erro na compilação.
    exit /b %ERRORLEVEL%
)

rem Muda para a pasta de saída
cd .\out

rem Executa a classe Main
java Main

rem Volta para o diretório original (opcional)
cd ..
