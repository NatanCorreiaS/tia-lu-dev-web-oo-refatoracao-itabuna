@echo off
rem Compila recursivamente todos os arquivos .java em src para out

rem Cria a pasta de saída, se não existir
if not exist out (
    mkdir out
)

rem Compila todos os .java dentro de src e subpastas
for /r .\src %%f in (*.java) do (
    echo Compilando %%f
)

javac -d out src\**\*.java

rem Verifica erro de compilação
if %ERRORLEVEL% NEQ 0 (
    echo Houve um erro na compilação.
    exit /b %ERRORLEVEL%
)

rem Executa a classe principal
cd out
java Main
cd ..
