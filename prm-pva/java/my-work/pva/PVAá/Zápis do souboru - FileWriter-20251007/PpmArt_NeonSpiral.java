import java.io.FileWriter;

public class PpmArt_NeonSpiral {
    // --- tweakables (or override via args) ---
    static int W = 1024;      // width
    static int H = 1024;      // height
    static double RINGS = 0.05;   // radial ring density (0.03–0.12 nice)
    static double TWIST = 10.0;   // angular twist (8–16 nice)
    static double PHASE = 0.0;    // global phase shift (try 0..6.283)

    public static void main(String[] args) throws Exception {
        // optional args: width height rings twist phase outname
        String out = "neon_spiral.ppm";
        if (args.length >= 1) W = Integer.parseInt(args[0]);
        if (args.length >= 2) H = Integer.parseInt(args[1]);
        if (args.length >= 3) RINGS = Double.parseDouble(args[2]);
        if (args.length >= 4) TWIST = Double.parseDouble(args[3]);
        if (args.length >= 5) PHASE = Double.parseDouble(args[4]);
        if (args.length >= 6) out = args[5];

        try (FileWriter fw = new FileWriter(out, false)) {
            fw.write("P3\n");
            fw.write(W + " " + H + "\n");
            fw.write("255\n");

            double cx = (W - 1) / 2.0;
            double cy = (H - 1) / 2.0;
            double minDim = Math.min(W, H);
            double vignetteR = 0.75 * (minDim / 2.0); // where vignette begins

            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    double dx = x - cx;
                    double dy = y - cy;
                    double r = Math.hypot(dx, dy);
                    double ang = Math.atan2(dy, dx);

                    // core pattern: mix angle & radius into smooth sine fields
                    double base = TWIST * ang + RINGS * r + PHASE;

                    // three channels = the same wave, phase-shifted by 120°
                    double cr = 0.5 + 0.5 * Math.sin(base);
                    double cg = 0.5 + 0.5 * Math.sin(base + 2.094395102);  // +120°
                    double cb = 0.5 + 0.5 * Math.sin(base + 4.188790205);  // +240°

                    // vignette for drama (soft falloff)
                    double v = r / vignetteR;
                    double fade = Math.exp(-v * v); // 1 in center → 0 at edges

                    int R = clamp255((int)Math.round(255 * cr * fade));
                    int G = clamp255((int)Math.round(255 * cg * fade));
                    int B = clamp255((int)Math.round(255 * cb * fade));

                    fw.write(R + " " + G + " " + B + " ");
                }
                fw.write("\n");
            }
        }
        System.out.println("✔ wrote " + out + " (" + W + "x" + H + ")");
    }

    static int clamp255(int x) { return (x < 0) ? 0 : (x > 255 ? 255 : x); }
}
