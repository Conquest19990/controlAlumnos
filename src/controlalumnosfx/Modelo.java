package controlalumnosfx;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Modelo {

    public Modelo() {
        //public Modelo(Vista vista){
        //view = vista;
    }

    public final String USERS_PATH_TXT = "Data/Users.txt";
    public String SEGUIMIENTO_PATH_CHOOSE;
    public final String SEGUIMIENTO_PATH = "C:\\Users\\mecob\\Documents\\ClasesMarz-Julio2021\\Ing-Software\\Unidad3\\ControlAlumnosFx\\src\\controlalumnosfx\\Data\\seguimiento.xlsx";
    public final String USERS_PATH = "C:\\Users\\mecob\\Documents\\ClasesMarz-Julio2021\\Ing-Software\\Unidad3\\ControlAlumnosFx\\src\\controlalumnosfx\\Data\\Usuarios.xlsx";
    private final String colSegui[] = {"N.Control", "Alumnos", "Sexo", "Edad", "Semestre", "Cr.Apr.", "Carga", "Promedio", "Especialidad"};
    private final String colUsers[] = {"Usuario", "Contraseña", "Nombre", "Ap.Paterno", "Ap.Materno", "Puesto"};

    private List<Object[]> rowsSegui;
    private List<Object[]> rowsUsers;
    private List<Usuarios> usuariosRow;
    private Usuarios usuario;
    private Object contraseña;
    
    private ArrayList<Alumnos> alumnos;
    
    public List<Object[]> getObjectArrayList() {
        return rowsSegui;
    }

    public String[] getColSegui() {
        return colSegui;

    }
    
    private void writeExcel() throws Exception {
        Workbook workbook = WorkbookFactory.create(new File(SEGUIMIENTO_PATH_CHOOSE));
        Sheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Hoja excel");

        //CellStyle headerStyle = workbook.createCellStyle();
        //Font font = workbook.createFont();
        //font.setBold(true);
        //headerStyle.setFont(font);

        //CellStyle style = workbook.createCellStyle();
        //style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < colSegui.length; ++i) {
            String header = colSegui[i];
            Cell cell = headerRow.createCell(i);
            //cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }

        for (int i = 0; i < alumnos.size(); ++i) {
            Row dataRow = sheet.createRow(i + 1);

            Alumnos alumBuff = alumnos.get(i);
            String ctrl = alumBuff.getnCtrl();
            String name = alumBuff.getNombre();
            String sex = alumBuff.getSexo();
            String edad = alumBuff.getEdad();
            String sem = alumBuff.getSem();
            String crApr = alumBuff.getCrApr();
            String carga = alumBuff.getCarga();
            String pro = alumBuff.getPromedio();
            String esp = alumBuff.getEspecialidad();
            
            dataRow.createCell(0).setCellValue(ctrl);
            dataRow.createCell(1).setCellValue(name);
            dataRow.createCell(2).setCellValue(sex);
            dataRow.createCell(2).setCellValue(edad);
            dataRow.createCell(2).setCellValue(sem);
            dataRow.createCell(2).setCellValue(crApr);
            dataRow.createCell(2).setCellValue(carga);
            dataRow.createCell(2).setCellValue(pro);
            dataRow.createCell(2).setCellValue(esp);
        }
        /*
        Row dataRow = sheet.createRow(1 + DATA.size());
        Cell total = dataRow.createCell(1);
        total.setCellType(CellType.FORMULA);
        total.setCellStyle(style);
        total.setCellFormula(String.format("SUM(B2:B%d)", 1 + DATA.size()));
        */
        FileOutputStream file = new FileOutputStream(SEGUIMIENTO_PATH_CHOOSE);
        workbook.write(file);
        file.close();
    }
    
    public ArrayList<Alumnos> importExcelSeguimiento() throws Exception {
        alumnos = new ArrayList<Alumnos>();
        rowsSegui = new ArrayList();
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SEGUIMIENTO_PATH_CHOOSE));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // 1. You can obtain a sheetIterator and iterate over it
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        int i = 0;

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            Object[] bufferObject;
            int col = 0;

            bufferObject = new Object[9];
            Alumnos bufferAlumno = new Alumnos();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");

                if (i > 0) {
                    //System.out.print(cellValue + "\t");
                    //rowsSegui.add(new Object[9]);

                    if (col == 0) {
                        bufferObject[0] = cellValue;
                        bufferAlumno.setnCtrl(new SimpleStringProperty((String) cellValue));

                    }
                    if (col == 1) {
                        bufferObject[1] = cellValue;
                        bufferAlumno.setNombre(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 2) {
                        bufferObject[2] = cellValue;
                        bufferAlumno.setSexo(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 3) {
                        bufferObject[3] = cellValue;
                        bufferAlumno.setEdad(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 4) {
                        bufferObject[4] = cellValue;
                        bufferAlumno.setSem(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 5) {
                        bufferObject[5] = cellValue;
                        bufferAlumno.setCrApr(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 6) {
                        bufferObject[6] = cellValue;
                        bufferAlumno.setCarga(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 7) {
                        bufferObject[7] = cellValue;
                        bufferAlumno.setPromedio(new SimpleStringProperty((String) cellValue));
                    }
                    if (col == 8) {
                        bufferObject[8] = cellValue;
                        bufferAlumno.setEspecialidad(new SimpleStringProperty((String) cellValue));
                    }
                }
                col++;
            }
            if (i > 0) {

                rowsSegui.add(bufferObject);
                alumnos.add(bufferAlumno);
            }
            i++;
            System.out.println();
        }

        workbook.close();
        return alumnos;
    }

    public boolean validateUsers(String user, String pass) throws Exception {
        System.out.println("Ey: " + user + "\ttu: " + pass);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        boolean flag = false;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            URL url = getClass().getResource(USERS_PATH_TXT);
            archivo = new File(url.getPath());

            //archivo = new File(USERS_PATH_TXT);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            //StringBuffer users;
            String linea;
            String usersStr[];
            while ((linea = br.readLine()) != null) {
                flag = false;
                usersStr = linea.split("\t");
                usuario = new Usuarios(usersStr[0], usersStr[1], usersStr[2], usersStr[3], usersStr[4], usersStr[5], usersStr[6]);
                System.out.println(usuario.getUsername());
                System.out.println(usuario.getPassword());
                if (usuario.getUsername().equals(user) && usuario.getPassword().equals(pass)) {
                    flag = true;
                    System.out.println(usuario.getUsername() + "\t" + usuario.getPassword());
                    System.out.println("Flagged");
                    break;
                } else {
                    flag = false;
                }
            }
            System.out.println("Hir");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            //flag = false;
        }
        return flag;
    }

    public void registroUsuario(String user,
            String pass,
            String inst,
            String name,
            String ap,
            String am,
            String psto) throws IOException {

        ////
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer usersData = new StringBuffer();
        usersData.setLength(0);
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            URL url = getClass().getResource(USERS_PATH_TXT);
            archivo = new File(url.getPath());

            //archivo = new File(USERS_PATH_TXT);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            //String usersStr[];
            while ((linea = br.readLine()) != null) {
                usersData.append(linea + "\n");
            }
            /*
            //String ruta = "filename.txt";
            String contenido = "Contenido de ejemplo";
            File file = new File(url.getPath());
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            */
            //System.out.println("Hir");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            //flag = false;
        }

        ////
        System.out.println(usersData.toString());
        System.out.println(user + "\t" + pass + "\t" + inst + "\t" + name + "\t" + ap + "\t" + am + "\t" + psto + "\t");

        try {
            String ruta = "src/controlalumnosfx/Data/Users.txt";
            String contenido = usersData.toString()+user + "\t" + pass + "\t" + inst + "\t" + name + "\t" + ap + "\t" + am + "\t" + psto + "\n";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ajio");
        }
        usersData.setLength(0);

    }

    public void setSEGUIMIENTO_PATH_CHOOSE(String SEGUIMIENTO_PATH_CHOOSE) {
        this.SEGUIMIENTO_PATH_CHOOSE = SEGUIMIENTO_PATH_CHOOSE;
    }
    
    
    
}
