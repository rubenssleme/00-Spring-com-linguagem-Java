SET ANSI_NULLS ON;

SET QUOTED_IDENTIFIER ON;

CREATE TABLE [dbo].[TipoMovimentacao](
	[IdTipoMovimentacao] [bigint] NOT NULL,
	[DescricaoTipoMovimentacao] [varchar](50) NOT NULL,

	[DataHoraAlteracao] [datetime] NOT NULL,
 CONSTRAINT [PK_TipoMovimentacao] PRIMARY KEY CLUSTERED
(
	[IdTipoMovimentacao] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY];

