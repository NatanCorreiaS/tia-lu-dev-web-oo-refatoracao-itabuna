echo "Compilando..."
mkdir -p out
javac -d out $(find ./src -name "*.java")

if [ $? -eq 0 ]; then
    echo "Compilado com sucesso."
    java -cp out Main
else
    echo "Erro na compilação."
fi
