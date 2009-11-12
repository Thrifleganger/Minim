/*
 *  Copyright (c) 2007 - 2008 by Damien Di Fede <ddf@compartmental.net>
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published
 *   by the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package ddf.minim.analysis;

public abstract class WindowFunction
{
  /** The float value of 2*PI. Provided as a convenience for subclasses. */
  protected static final float TWO_PI = (float) (2 * Math.PI);
  protected int length;
  
  public WindowFunction()
  {
  }

  public void apply(float[] samples) {
    this.length = samples.length;

    for ( int n = 0; n < samples.length; n ++ ) {
      samples[n] *= value(samples.length, n);
    }
  }

  public float[] curve(int length)
  {
    float[] samples = new float[length];
    for (int n = 0; n < length; n++) {
      samples[n] = 1f;  
    }
    apply(samples);
    return samples;
  }

  protected abstract float value(int length, int index);
}
