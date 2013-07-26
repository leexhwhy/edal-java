/*******************************************************************************
 * Copyright (c) 2013 The University of Reading
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the University of Reading, nor the names of the
 *    authors or contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/

package uk.ac.rdg.resc.edal.domain;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import uk.ac.rdg.resc.edal.feature.TrajectoryFeature;
import uk.ac.rdg.resc.edal.geometry.BoundingBox;
import uk.ac.rdg.resc.edal.position.GeoPosition;
import uk.ac.rdg.resc.edal.position.VerticalCrs;
import uk.ac.rdg.resc.edal.position.VerticalPosition;

/**
 * The domain of a {@link TrajectoryFeature}: a set of positions in space and
 * time.
 * 
 * @author Jon Blower
 */
public interface TrajectoryDomain extends DiscretePointDomain<GeoPosition> {
    /**
     * @return the vertical coordinate reference system used to reference the
     *         {@link #getDomainObjects() positions}.
     */
    public VerticalCrs getVerticalCrs();

    /**
     * @return the horizontal coordinate reference system used to reference the
     *         {@link #getDomainObjects() positions}.
     */
    public CoordinateReferenceSystem getHorizontalCrs();

    /**
     * @return the calendar system used to reference the temporal components of
     *         the {@link #getDomainObjects() positions}.
     */
    public Chronology getChronology();

    /**
     * @return a {@link BoundingBox} which fully contains this
     *         {@link TrajectoryDomain}
     */
    public BoundingBox getCoordinateBounds();

    /**
     * @return an {@link Extent} which fully contains this
     *         {@link TrajectoryDomain}
     */
    public Extent<DateTime> getTimeExtent();

    /**
     * @return an {@link Extent} which fully contains this
     *         {@link TrajectoryDomain}
     */
    public Extent<VerticalPosition> getVerticalExtent();
}
