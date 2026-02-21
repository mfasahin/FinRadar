
import zipfile
import xml.etree.ElementTree as ET

def read_docx(file_path):
    try:
        with zipfile.ZipFile(file_path) as docx:
            xml_content = docx.read('word/document.xml')
            tree = ET.fromstring(xml_content)
            
            text = []
            ns = {'w': 'http://schemas.openxmlformats.org/wordprocessingml/2006/main'}
            
            for paragraph in tree.iterfind('.//w:p', namespaces=ns):
                line = []
                for node in paragraph.iterfind('.//w:t', namespaces=ns):
                    if node.text:
                        line.append(node.text)
                if line:
                    text.append(''.join(line))
            
            return '\n'.join(text)
    except Exception as e:
        return f"Error reading docx: {str(e)}"

if __name__ == "__main__":
    with open("requirements.txt", "w", encoding="utf-8") as f:
        f.write(read_docx("FinRadar_Proje_Dokumani.docx"))
