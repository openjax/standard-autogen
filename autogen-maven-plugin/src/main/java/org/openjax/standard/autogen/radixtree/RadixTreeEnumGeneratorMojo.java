/* Copyright (c) 2014 OpenJAX
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.openjax.standard.autogen.radixtree;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.openjax.standard.maven.mojo.GeneratorMojo;

/**
 * Maven MOJO for {@link RadixTreeEnumGenerator}.
 */
@Mojo(name="radixtree", defaultPhase=LifecyclePhase.GENERATE_SOURCES)
@Execute(goal="radixtree")
public final class RadixTreeEnumGeneratorMojo extends GeneratorMojo {
  @Parameter(property="inFile", required=true)
  private File inFile;

  @Parameter(property="className", required=true)
  private String className;

  @Parameter(property="inheritsFrom")
  private String inheritsFrom;

  @Override
  public void execute(final Configuration configuration) throws MojoExecutionException, MojoFailureException {
    try {
      RadixTreeEnumGenerator.generate(className, inheritsFrom, new File(configuration.getDestDir(), className.replace('.', '/') + ".java"), new FileReader(inFile));
    }
    catch (final IOException e) {
      throw new MojoExecutionException(e.getClass().getSimpleName() + ": " + e.getMessage(), e);
    }
  }
}