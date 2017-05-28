package com.gedix;

import java.io.File;
import java.io.IOException;

import example.avro.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testSerialization() throws IOException {
        User u = User.newBuilder().setName("Salih").setFavoriteColor("Blue").setFavoriteNumber(13).build();
        File store = File.createTempFile("salih","avro");
        DatumWriter<User> datumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> userDataFileWriter = new DataFileWriter<>(datumWriter);
        userDataFileWriter.create(u.getSchema(),store);
        userDataFileWriter.append(u);
        userDataFileWriter.close();



        assertEquals(u.getName(),"Salih");
    }
}
