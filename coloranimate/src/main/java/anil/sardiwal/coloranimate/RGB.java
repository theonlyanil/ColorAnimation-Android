package anil.sardiwal.coloranimate;

public class RGB
{
    // Continuous Color change - Action bar / Toolbar
    public static int returningColor()
    {
    int pos = ColorAnimation.pos;
        final int[] rainbowColors = new int[]
                {

                        (R.color.red),
                        (R.color.pink),
                        (R.color.purple),
                        (R.color.deep_purple),
                        (R.color.indigo),
                        (R.color.blue),
                        (R.color.light_blue),
                        (R.color.cyan),
                        (R.color.teal),
                        (R.color.green),
                        (R.color.light_green),
                        (R.color.lime),
                        (R.color.yellow),
                        (R.color.amber),
                        (R.color.orange),
                        (R.color.deep_orange),
                        (R.color.orange),
                        (R.color.amber),
                        (R.color.yellow),
                        (R.color.lime),
                        (R.color.light_green),
                        (R.color.green),
                        (R.color.teal),
                        (R.color.cyan),
                        (R.color.light_blue),
                        (R.color.blue),
                        (R.color.indigo),
                        (R.color.deep_purple),
                        (R.color.purple),
                        (R.color.pink),
                        (R.color.red)
                };


        if(pos < rainbowColors.length-1)
        {
            pos++;
            return rainbowColors[pos];
        }
        else
        {
            pos = 0;
            return rainbowColors[pos];
        }
    }
}
