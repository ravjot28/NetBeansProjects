/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BookReading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipFolder
{
    public void unzipFolder( String zipFile, String destFolder ) {
try {
ZipFile zf = new ZipFile(zipFile);
Enumeration< ? extends ZipEntry> zipEnum = zf.entries();
String dir = destFolder;

while( zipEnum.hasMoreElements() ) {
ZipEntry item = (ZipEntry) zipEnum.nextElement();

if (item.isDirectory()) {
File newdir = new File(dir + File.separator + item.getName());
newdir.mkdir();
} else {
String newfilePath = dir + File.separator + item.getName();
File newFile = new File(newfilePath);
if (!newFile.getParentFile().exists()) {
newFile.getParentFile().mkdirs();
}

InputStream is = zf.getInputStream(item);
FileOutputStream fos = new FileOutputStream(newfilePath);
int ch;
while( (ch = is.read()) != -1 ) {
fos.write(ch);
}
is.close();
fos.close();
}
}
zf.close();
new FullScreen("Bin\\Data\\Temp\\");
} catch (Exception e) {
e.printStackTrace();
}
}
}
