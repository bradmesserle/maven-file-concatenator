package com.messerleassoc.mave.file.concatenator;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.sonatype.plexus.build.incremental.BuildContext;


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

	/** Plug in Context PLUGIN Descriptor Key **/
	private static final String PLUGIN_DESCRIPTOR_KEY = "pluginDescriptor";
	
	
	/**
	 * Current Maven Project Object
	 */
	@Parameter(defaultValue="${project",readonly=true,required=true)
	private MavenProject project;
	
	
	@Component
	private BuildContext buildContext;
	
	
	/**
	 * List of scripts to concatenate
	 */
	@Parameter(readonly=true, required=true)
	private List<String> scriptList;
	
	/**
	 * Output Directory
	 */
	@Parameter(defaultValue = "${project.build.directory}/genereted-resouces") 
	private File outputDirectory;
	
	
	/**
	 * Execute the MAVEN PLUGIN
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		final PluginDescriptor pd = (PluginDescriptor) this.getPluginContext().get(PLUGIN_DESCRIPTOR_KEY);
		
		if (pd.getDependencies().isEmpty()){
			throw new MojoFailureException("Missing dependent scripts project configured");
		}
		
		
		buildContext.refresh(this.getOutputDirectory());
		
		
		
		
	}


	/**
	 * @return the outputDirectory
	 */
	public final File getOutputDirectory() {
		return outputDirectory;
	}


	/**
	 * @param outputDirectory the outputDirectory to set
	 */
	public final void setOutputDirectory(File outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
	
	
	
	
	
	
	

}
