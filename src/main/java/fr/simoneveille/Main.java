package fr.simoneveille;

import fr.simoneveille.domain.MowingProgramInput;
import fr.simoneveille.domain.Simulator;
import fr.simoneveille.io.InputFileReader;
import fr.simoneveille.parser.InvalidInputException;
import fr.simoneveille.parser.MowingProgramInputParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public class Main
{
    public static void main( String[] args )
    {

        if (args.length != 1) {
            System.err.println("Usage: java -jar mow-it-now.jar <input-file>");
            System.exit(1);
        }

        Path inputPath = Path.of(args[0]);

        try {
            InputFileReader fileReader = new InputFileReader();
            MowingProgramInputParser parser = new MowingProgramInputParser();

            List<String> lines = fileReader.readLines(inputPath);
            MowingProgramInput input = parser.parse(lines);


            Simulator simulator = new Simulator(input);
            simulator.run();



        } catch (IOException e) {
            System.err.println("Unable to read input file: " + inputPath);
            System.exit(1);
        } catch (InvalidInputException e) {
            System.err.println("Invalid input file: " + e.getMessage());
            System.exit(1);
        }



    }
}
