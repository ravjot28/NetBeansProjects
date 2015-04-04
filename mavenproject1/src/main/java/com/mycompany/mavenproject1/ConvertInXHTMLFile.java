/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

import java.io.File;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.docx4j.XmlUtils;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.convert.out.html.AbstractHtmlExporter;
import org.docx4j.convert.out.html.AbstractHtmlExporter.HtmlSettings;
import org.docx4j.convert.out.html.HtmlExporterNG2;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;

/**
 * This sample converts XHTML to docx content.
 * 
 * If the XHTML is escaped (as required for OpenDoPE input), it
 * is unescaped first.
 *
 * For best results, be sure to include src/main/resources on your classpath.
 *  
 */
public class ConvertInXHTMLFile {

    public static void main(String[] args) throws Exception {
        
        String inputfilepath =  "/Users/ravjotsingh/Desktop/ucc client profile monoline.xhtml";
        
        String stringFromFile = FileUtils.readFileToString(new File(inputfilepath), "UTF-8");
        
        String unescaped = stringFromFile;
        if (stringFromFile.contains("&lt;/") ) {
    		unescaped = StringEscapeUtils.unescapeHtml(stringFromFile);        	
        }
        
		
		System.out.println("Unescaped: " + unescaped);
        
        XHTMLImporter.setHyperlinkStyle("Hyperlink");
        
        // Create an empty docx package
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
		
		NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
		wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
		ndp.unmarshalDefaultNumbering();		
					
		// Convert the XHTML, and add it into the empty docx we made
		wordMLPackage.getMainDocumentPart().getContent().addAll( 
				 XHTMLImporter.convert(unescaped, null, wordMLPackage) );

                
		System.out.println(
				XmlUtils.marshaltoString(wordMLPackage.getMainDocumentPart().getJaxbElement(), true, true));
		
		wordMLPackage.save(new java.io.File("/Users/ravjotsingh/Desktop/html_output.docx") );
      
  }
	
}
