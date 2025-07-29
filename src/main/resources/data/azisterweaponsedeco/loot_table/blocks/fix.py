import os
import json

def generate_loot_table_json(file_name_without_extension):
    """
    Gera o conteúdo JSON da loot table com o nome do arquivo.
    """
    return {
        "type": "minecraft:block",
        "pools": [
            {
                "rolls": 1.0,
                "conditions": [
                    {
                        "condition": "minecraft:survives_explosion"
                    }
                ],
                "entries": [
                    {
                        "type": "minecraft:item",
                        "name": f"azisterweaponsedeco:{file_name_without_extension}"
                    }
                ]
            }
        ]
    }

def process_json_files_in_directory():
    """
    Processa todos os arquivos JSON na pasta atual, alterando seu conteúdo.
    """
    current_directory = os.getcwd()
    print(f"Buscando arquivos JSON na pasta: {current_directory}")

    for filename in os.listdir(current_directory):
        if filename.endswith(".json"):
            file_path = os.path.join(current_directory, filename)
            base_name = os.path.splitext(filename)[0] # Pega o nome do arquivo sem a extensão

            new_content = generate_loot_table_json(base_name)

            try:
                with open(file_path, 'w', encoding='utf-8') as f:
                    json.dump(new_content, f, indent=2, ensure_ascii=False)
                print(f"Arquivo '{filename}' atualizado com sucesso. Item: azisterweaponsedeco:{base_name}")
            except Exception as e:
                print(f"Erro ao processar o arquivo '{filename}': {e}")
        else:
            print(f"Ignorando arquivo '{filename}' (não é um arquivo JSON).")

if __name__ == "__main__":
    process_json_files_in_directory()
    print("\nProcesso concluído.")
