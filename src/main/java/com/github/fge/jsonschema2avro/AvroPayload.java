/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of both licenses is available under the src/resources/ directory of
 * this project (under the names LGPL-3.0.txt and ASL-2.0.txt respectively).
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package com.github.fge.jsonschema2avro;


import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.tree.SchemaTree;

public final class AvroPayload
    implements MessageProvider
{
    private final SchemaTree tree;
    private final AvroWriterProcessor writer;

    public AvroPayload(final SchemaTree tree, final AvroWriterProcessor writer)
    {
        this.tree = tree;
        this.writer = writer;
    }

    public SchemaTree getTree()
    {
        return tree;
    }

    public AvroWriterProcessor getWriter()
    {
        return writer;
    }

    @Override
    public ProcessingMessage newMessage()
    {
        return new ProcessingMessage().put("schema", tree);
    }
}
