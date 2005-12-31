package org.apache.maven.jxr;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;
import org.apache.maven.jxr.pacman.PackageManager;
import org.apache.maven.jxr.pacman.FileManager;

import java.io.File;
import java.util.Locale;

public class CodeTransformTest
    extends TestCase
{

    private CodeTransform codeTransform;

    private PackageManager packageManager;

    protected void setUp()
        throws Exception
    {
        super.setUp();
        packageManager = new PackageManager( new DummyLog(), new FileManager() );
        codeTransform = new CodeTransform( packageManager );
    }

    public void testTransform()
        throws Exception
    {
        File sourceFile = new File(
            System.getProperty( "basedir" ) + "/src/test/java/org/apache/maven/jxr/CodeTransformTest.java" );
        assertTrue( sourceFile.exists() );
        codeTransform.transform( sourceFile.getAbsolutePath(),
                                 System.getProperty( "basedir" ) + "/target/CodeTransformTest.html", Locale.ENGLISH,
                                 "ISO-8859-1", "ISO-8859-1", "", "" );
        assertTrue( new File( System.getProperty( "basedir" ), "/target/CodeTransformTest.html" ).exists() );
    }

}