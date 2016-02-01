package com.messerleassoc.mave.file.concatenator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;


/**
 * File concatenator maven plugin
 * 
 * @author bradmesserle
 * @since 1/31/2016
 *
 */
@Mojo(name = "processFiles",
      threadSafe = false,
      defaultPhase = LifecyclePhase.GENERATE_RESOURCES,
      requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
public class FileConcatenatorMojo extends AbstractMojo {

	public void execute() throws MojoExecutionException, MojoFailureException {
		// TODO Auto-generated method stub
		
	}

}
